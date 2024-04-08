package com.hmdp.service.impl;

import com.hmdp.dto.Result;
import com.hmdp.entity.SeckillVoucher;
import com.hmdp.entity.VoucherOrder;
import com.hmdp.mapper.VoucherOrderMapper;
import com.hmdp.service.ISeckillVoucherService;
import com.hmdp.service.IVoucherOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.utils.RedisIDWorker;
import com.hmdp.utils.UserHolder;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class VoucherOrderServiceImpl extends ServiceImpl<VoucherOrderMapper, VoucherOrder> implements IVoucherOrderService {
    @Resource
    private ISeckillVoucherService seckillVoucherService;//在优惠券下单的实现类中注入秒杀的的对象,用的是人家的方法

    @Resource
    private RedisIDWorker redisIDWorker;

    /**
     * @param voucherId 秒杀券和普通券共享id
     * @return
     */
    @Override
    @Transactional//因为这段代码涉及了两张数据库表，一张扣减库存（优惠券表），一张更新订单（订单表）所以放在同一事务中
    public Result seckillVoucher(Long voucherId) {
        //1查询优惠券
        SeckillVoucher voucher = seckillVoucherService.getById(voucherId);
        //2判断秒杀是否开始
        if (voucher.getBeginTime().isAfter(LocalDateTime.now())) {
            //
            return Result.fail("秒杀尚未开始");
        }
        //3判断秒杀是否结束
        if (voucher.getEndTime().isBefore(LocalDateTime.now())) {
            //
            return Result.fail("秒杀已经结束");
        }
        //4判断库存是否充足
        if (voucher.getStock() < 1) {
            return Result.fail("库存不足");
        }
        //一人一单功能添加，将扣减库存和创建订单等功能封装在一个方法中——先获取锁，再提交业务。
        Long userId = UserHolder.getUser().getId();
        synchronized (userId.toString().intern()) {
            return createVoucherOrder(voucherId);
        }
    }

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
