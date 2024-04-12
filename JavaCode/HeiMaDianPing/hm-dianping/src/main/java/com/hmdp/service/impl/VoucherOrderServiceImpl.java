package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.hmdp.dto.Result;
import com.hmdp.entity.VoucherOrder;
import com.hmdp.mapper.VoucherOrderMapper;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IVoucherOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.utils.RedisIDWorker;
import com.hmdp.utils.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
@Slf4j
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {
    @Resource
    private ISeckillVoucherService seckillVoucherService;//在优惠券下单的实现类中注入秒杀的的对象,用的是人家的方法

    @Resource
    private RedisIDWorker redisIDWorker;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //用于执行lua脚本
    private static final DefaultRedisScript<Long> SECKILL_SCRIPT;
    static {
        SECKILL_SCRIPT = new DefaultRedisScript<>();
        SECKILL_SCRIPT.setLocation(new ClassPathResource("seckill.lua"));
        SECKILL_SCRIPT.setResultType(Long.class);
    }

//    //阻塞队列,如果队列中没有，线程就会阻塞，有了才会获取。
//    private BlockingQueue<VoucherOrder> orderTasks = new ArrayBlockingQueue<>(1024 * 1024);

    //
    private static final ExecutorService SECKILL_ORDER_EXECUTOR = Executors.newSingleThreadExecutor();
    @PostConstruct
    private void init(){
        SECKILL_ORDER_EXECUTOR.submit(new VoucherOrderHandler());
    }
    private class VoucherOrderHandler implements Runnable{
        String queueName = "stream.orders";
        @Override
        public void run() {
            //
            while (true){
                try {
                    //获取消息队列中的订单信息XREADGROUP GROUP g1 c1 COUNT 1 BLOCK 2000 STREAMS streams.order >
                    List<MapRecord<String, Object, Object>> list = stringRedisTemplate.opsForStream().read(
                            Consumer.from("g1", "c1"),
                            StreamReadOptions.empty().count(1).block(Duration.ofSeconds(2)),
                            StreamOffset.create(queueName, ReadOffset.lastConsumed())
                    );
                    //判断消息获取是否成功，如果获取失败继续下一次循环
                    if (list == null || list.isEmpty()){
                        continue;
                    }
                    //成功就创建订单
                    //先解析消息中的订单信息
                    MapRecord<String, Object, Object> record = list.get(0);
                    Map<Object, Object> values = record.getValue();//发消息时就是拿着key-value形式发的
                    VoucherOrder voucherOrder = BeanUtil.fillBeanWithMap(values, new VoucherOrder(), true);
                    handleVoucherOrder(voucherOrder);
                    //进行ack确认 SACK stream.orders g1 id 这个id是消息队列的id stream.order
                    stringRedisTemplate.opsForStream().acknowledge(queueName,"g1", record.getId());
                } catch (Exception e) {
                    log.error("处理订单异常", e);
                    //确认出现异常，就放到pendinglist中，再次处理
                    handlePendingList();
                }
            }
        }
    }

    private void handlePendingList() {
        String queueName = "stream.orders";
        while (true){
            try {
                //获取Pending-List中的订单信息XREADGROUP GROUP g1 c1 COUNT 1 BLOCK 2000 STREAMS streams.order >
                List<MapRecord<String, Object, Object>> list = stringRedisTemplate.opsForStream().read(
                        Consumer.from("g1", "c1"),
                        StreamReadOptions.empty().count(1),
                        StreamOffset.create(queueName, ReadOffset.from("0"))
                );
                //判断消息获取是否成功，如果获取失败继续下一次循环
                if (list == null || list.isEmpty()){
                    break;//说明pending-list中没有异常消息，需要结束循环
                }
                //成功就创建订单
                //先解析消息中的订单信息
                MapRecord<String, Object, Object> record = list.get(0);
                Map<Object, Object> values = record.getValue();//发消息时就是拿着key-value形式发的
                VoucherOrder voucherOrder = BeanUtil.fillBeanWithMap(values, new VoucherOrder(), true);
                handleVoucherOrder(voucherOrder);
                //进行ack确认 SACK stream.orders g1 id 这个id是消息队列的id stream.order
                stringRedisTemplate.opsForStream().acknowledge(queueName,"g1", record.getId());
            } catch (Exception e) {
                //pendinglist中出现异常
                log.error("处理pendinglist异常", e);
            }
        }
    }

    private void handleVoucherOrder(VoucherOrder voucherOrder) {
        Long userId = voucherOrder.getUserId();//获取用户
        //

    }

    /**使用lua脚本和阻塞队列来完成业务
     * @param voucherId 秒杀券和普通券共享id
     * @return
     */
    @Override
    public Result seckillVoucher(Long voucherId) {
        //获取用户
        Long userId = UserHolder.getUser().getId();
        //订单id
        long orderId = redisIDWorker.nextId("order");
        //执行lua脚本,判断库存以及一人一单,并且将消息发送到消息队列中
        Long result = stringRedisTemplate.execute(SECKILL_SCRIPT, Collections.emptyList(),
                voucherId.toString(), userId.toString(), String.valueOf(orderId));
        //判断结果是否为0，如果为0才有购买资格
        int r = result.intValue();
        if (r != 0){
            return Result.fail(r == 1 ? "库存不足" : "不能重复下单");
        }
        //获取代理对象，为了让以后的子线程可以拿到
        proxy = (IVoucherOrderService) AopContext.currentProxy();
        //异步下单

        //返回订单id
        return Result.ok(orderId);
    }

    private IVoucherOrderService proxy;
//    public Result seckillVoucher(Long voucherId) {
//        //获取用户
//        Long userId = UserHolder.getUser().getId();
//        //执行lua脚本,判断库存以及一人一单
//        Long result = stringRedisTemplate.execute(SECKILL_SCRIPT, Collections.emptyList(),
//                voucherId.toString(), userId.toString());
//        //判断结果是否为0，如果为0才有购买资格
//        int r = result.intValue();
//        if (r != 0){
//            return Result.fail(r == 1 ? "库存不足" : "不能重复下单");
//        }
//        //将下单信息保存在阻塞队列中
//        VoucherOrder voucherOrder = new VoucherOrder();
//        long orderId = redisIDWorker.nextId("order");//订单id
//        voucherOrder.setId(orderId);
//        //用户id
//        voucherOrder.setUserId(userId);
//        //秒杀券id
//        voucherOrder.setVoucherId(voucherId);
//        //加入阻塞队列
//        orderTasks.add(voucherOrder);
//        //获取代理对象，为了让以后的子线程可以拿到
//        proxy = (IVoucherOrderService) AopContext.currentProxy();
//        //异步下单
//
//        //返回订单id
//        return Result.ok(orderId);
//    }
    //因为这段代码涉及了两张数据库表，一张扣减库存（优惠券表），一张更新订单（订单表）所以放在同一事务中
//    public Result seckillVoucher(Long voucherId) {
//        //1查询优惠券
//        SeckillVoucher voucher = seckillVoucherService.getById(voucherId);
//        //2判断秒杀是否开始
//        if (voucher.getBeginTime().isAfter(LocalDateTime.now())) {
//            //
//            return Result.fail("秒杀尚未开始");
//        }
//        //3判断秒杀是否结束
//        if (voucher.getEndTime().isBefore(LocalDateTime.now())) {
//            //
//            return Result.fail("秒杀已经结束");
//        }
//        //4判断库存是否充足
//        if (voucher.getStock() < 1) {
//            return Result.fail("库存不足");
//        }
//        //一人一单功能添加，将扣减库存和创建订单等功能封装在一个方法中——先获取锁，再提交业务。
//        Long userId = UserHolder.getUser().getId();
//        synchronized (userId.toString().intern()) {
//            return createVoucherOrder(voucherId);
//        }
//    }

    /**
     * 创建订单
     * @param voucherId
     * @return
     */
    @Transactional
    public Result createVoucherOrder(Long voucherId) {
        //一人一单功能添加
        Long userId = UserHolder.getUser().getId();
        //对用户id添加悲观锁
        int count = query().eq("user_id", userId).eq("voucher_id", voucherId).count();
        if (count > 0) {
            //用户已经下过单了
            return Result.fail("用户已经购买过");
        }

        //5扣减库存并加上了乐观"锁"
        boolean success = seckillVoucherService.update().
                setSql("stock = stock - 1").//set stock = stock - 1
                        eq("voucher_id", voucherId).gt("stock", 0)//where id = ? and stock > 0
                .update();//这里怎么把sql语句弄上了
        if (!success) {
            return Result.fail("库存不足");
        }

        //6创建订单
        VoucherOrder voucherOrder = new VoucherOrder();
        //订单id，用户id。代金券id
        long orderId = redisIDWorker.nextId("order");
        voucherOrder.setId(orderId);
        //
        voucherOrder.setUserId(userId);
        //
        voucherOrder.setVoucherId(voucherId);
        //订单写入数据库
        save(voucherOrder);

        return Result.ok(orderId);
    }
}
