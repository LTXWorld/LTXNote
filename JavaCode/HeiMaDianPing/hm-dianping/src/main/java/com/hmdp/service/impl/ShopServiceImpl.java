package com.hmdp.service.impl;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hmdp.dto.Result;
import com.hmdp.entity.Shop;
import com.hmdp.mapper.ShopMapper;
import com.hmdp.service.IShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.utils.CacheClient;
import com.hmdp.utils.RedisData;
import com.hmdp.utils.SystemConstants;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.domain.geo.GeoReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.hmdp.utils.RedisConstants.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 虎哥
 * @since 2021-12-22
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements IShopService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private CacheClient cacheClient;

    /**
     * 根据商铺ID查询商铺信息，调用了下面的方法
     * @param id
     * @return
     */
    @Override
    public Result queryById(Long id) {
        //解决缓存穿透
        //Shop shop = queryWithPassThrough(id);
        //使用互斥锁
//        Shop shop = queryWithMutex(id);
        //使用工具类的解决缓存穿透
        Shop shop1 = cacheClient.queryWithPassThrough(CACHE_SHOP_KEY, id, Shop.class, id2 -> getById(id2), CACHE_SHOP_TTL, TimeUnit.SECONDS);
        //使用工具类解决击穿
        Shop shop2 = cacheClient.queryWithLogicalExpire(CACHE_SHOP_KEY, id, Shop.class, id2 -> getById(id2), CACHE_SHOP_TTL, TimeUnit.SECONDS);
        //使用逻辑过期（但没有使用缓存穿透）
        Shop shop = queryWithLogicalExpire(id);
        if (shop == null){
            return Result.fail("店铺不存在！");
        }
        //
        return Result.ok(shop);
    }

    /**
     * 尝试获取锁
     * @param key 代表锁，由使用此方法者传递
     * @return
     */
    private boolean tryGetLock(String key){
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(key, "1", 10, TimeUnit.SECONDS);
        return BooleanUtil.isTrue(flag);
    }

    /**
     * 释放锁
     * @param key
     */
    private void unLock(String key){
        stringRedisTemplate.delete(key);
    }

    /**
     * 更新商铺信息,因为是单体项目所以将其放在同一个事务当中
     * @param shop
     * @return
     */
    @Override
    @Transactional
    public Result update(Shop shop) {
        Long id = shop.getId();
        if (id == null) {
            return Result.fail("店铺id不为空");
        }
        //先更新数据库
        updateById(shop);
        //再删除缓存
        stringRedisTemplate.delete(CACHE_SHOP_KEY + id);
        return Result.ok();
    }

    /**
     * 通过店铺类型和经纬度进行店铺的分页查询
     * @param typeId
     * @param current
     * @param x
     * @param y
     * @return
     */
    @Override
    public Result queryShopByType(Integer typeId, Integer current, Double x, Double y) {
        //判断是否需要根据坐标查询
        if (x == null || y == null){
            //不需要坐标时，使用数据库查询
            Page<Shop> page = query().eq("type:id", typeId)
                    .page(new Page<>(current, SystemConstants.DEFAULT_PAGE_SIZE));
            return Result.ok(page.getRecords());
        }
        //如果需要坐标查询，即将使用Redis
        //先计算分页参数
        int from = (current - 1) * SystemConstants.DEFAULT_PAGE_SIZE;
        int end = current * SystemConstants.DEFAULT_PAGE_SIZE;
        //查询redis，按照距离排序并分页；查询得到店铺id以及距离
        String key = SHOP_GEO_KEY + typeId;
        GeoResults<RedisGeoCommands.GeoLocation<String>> results = stringRedisTemplate.opsForGeo()// GEOSEARCH key,
                .search(
                        key,
                        GeoReference.fromCoordinate(x, y),
                        new Distance(5000),
                        //这里limit end 返回的是0-end，所以必须在下面进行截取（利用stream流截取）
                        RedisGeoCommands.GeoSearchCommandArgs.newGeoSearchArgs().includeDistance().limit(end)
                );
        //
        if (results == null){
            return Result.ok(Collections.emptyList());
        }
        //将结果集合转换为list集合（这一步为什么多转化一步）
        List<GeoResult<RedisGeoCommands.GeoLocation<String>>> list = results.getContent();
        //用于存储
        List<Long> ids = new ArrayList<>(list.size());//用于保存店铺的id
        Map<String, Distance> distanceMap = new HashMap<>(list.size());//用于将距离和店铺联系在一起
        //截取from-end的部分
        list.stream().skip(from).forEach(result ->{
            //获取店铺id并放入ids列表中
            String shopIdStr = result.getContent().getName();
            ids.add(Long.valueOf(shopIdStr));
            //获取距离,并联系店铺放在map中
            Distance distance = result.getDistance();
            distanceMap.put(shopIdStr, distance);
        });
        //根据id查询店铺
        String idStr = StrUtil.join(",", ids);
        List<Shop> shops = query().in("id", ids).last("ORDER BY FIELD(id," + idStr + ")").list();
        for (Shop shop : shops) {
            shop.setDistance(distanceMap.get(shop.getId().toString()).getValue());//shop的有一个属性是距离
        }
        return Result.ok(shops);
    }

    /**
     * 单一处理缓存穿透的加空值""，没有加互斥锁。
     * @param id
     * @return
     */
    public Shop queryWithPassThrough(Long id) {
            String key = CACHE_SHOP_KEY + id;
            //1查询redis中的商铺缓存
            String shopJSON = stringRedisTemplate.opsForValue().get(key);
            //2存在直接返回
            if (StrUtil.isNotBlank(shopJSON)) {//isNotBlank这个方法意味着只有shopJSON有数据时才会返回true
                Shop shop = JSONUtil.toBean(shopJSON, Shop.class);
                return shop;
            }
            //从上面下来就剩两种情况：null或者空字符串
            if (shopJSON != null) {
                return null;//这里意味着是空字符串"",
            }
            //3redis中为null，根据id查询数据库
            Shop shop = getById(id);
            if (shop == null) {
                //4数据库中也没有，并且使用缓存空对象来避免缓存穿透
                stringRedisTemplate.opsForValue().set(key, "", CACHE_NULL_TTL, TimeUnit.MINUTES);//将空值写入redis当中
                return null;
            }
            //5存在写入redis并返回
            stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(shop), CACHE_SHOP_TTL, TimeUnit.MINUTES);
            return shop;
        }

    /**
     * 并使用redis缓存技术,并且缓存null值来解决缓存击穿+互斥锁
     * @param id
     * @return
     */
    public Shop queryWithMutex(Long id){
        String key = CACHE_SHOP_KEY + id;
        //1查询redis中的商铺缓存
        String shopJSON = stringRedisTemplate.opsForValue().get(key);
        //2存在直接返回
        if (StrUtil.isNotBlank(shopJSON)) {
            Shop shop = JSONUtil.toBean(shopJSON, Shop.class);
            return shop;
        }
        //需要判断命中是否为空值""
        if (shopJSON != null) {
            return null;
        }
        //如果redis中没有且不是空值，就要来操作数据库了
        //获取互斥锁，判断是否获取成功;失败则休眠并重试，成功根据id查询数据库写入Redis
        String lockKey = "" + id;
        Shop shop = null;
        try {
            boolean isLock = tryGetLock(lockKey);
            //
            if (!isLock) {
                //失败
                Thread.sleep(50);
                //休眠完后递归调用重新查询
                return queryWithMutex(id);
            }
            //如果获取锁成功，根据id查询数据库
            shop = getById(id);
            if (shop == null) {
                //4不存在报错，并且使用缓存空对象来避免缓存穿透
                stringRedisTemplate.opsForValue().set(key, "", CACHE_NULL_TTL, TimeUnit.MINUTES);//将空值写入redis当中
                return null;
            }
            //5存在写入redis并返回
            stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(shop), CACHE_SHOP_TTL, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //释放互斥锁
            unLock(lockKey);
        }

        return shop;
    }

    /**
     * 使用逻辑过期时间将Shop存入缓存redis中,即缓存重建过程代码
     * @param id 店铺id
     * @param expireSeconds 过期时间
     */
    public void saveShop2Redis(Long id, Long expireSeconds) throws InterruptedException {
        //查询店铺数据
        Shop shop = getById(id);
        Thread.sleep(200);
        //封装逻辑过期时间
        RedisData redisData = new RedisData();
        redisData.setData(shop);//工具类中的redisData对象，将shop作为其data
        redisData.setExpireTime(LocalDateTime.now().plusSeconds(expireSeconds));
        //写入redis
        stringRedisTemplate.opsForValue().set(CACHE_SHOP_KEY + id, JSONUtil.toJsonStr(redisData));
        //并没有为这个数据设置TTL，这个过期时间是由我们手动在上面管理的
    }

    //开启线程池
    private static final ExecutorService CACHE_REBUILD_EXECUTOR = Executors.newFixedThreadPool(10);
    /**
     * 使用逻辑过期时间来解决缓存击穿，不用考虑缓存穿透
     * @param id
     * @return
     */
    public Shop queryWithLogicalExpire(Long id) {
        String key = CACHE_SHOP_KEY + id;
        //1查询redis中的商铺缓存
        String shopJSON = stringRedisTemplate.opsForValue().get(key);
        //2不存在直接返回
        if (StrUtil.isBlank(shopJSON)) {
            return null;
        }
        //存在，需要判断是否过期
        //先把json反序列化为对象，拿出其中的逻辑过期时间判断是否过期
        RedisData redisData = JSONUtil.toBean(shopJSON, RedisData.class);//获取一个更广泛的从Redis中检索到的数据集，此例包含时间和对象
        JSONObject data = (JSONObject)redisData.getData();//拿到其中存储的数据，格式为JSON。真正的对象data即shop
        //拿到真正的shop对象和逻辑过期时间
        Shop shop = JSONUtil.toBean(data, Shop.class);
        LocalDateTime expireTime = redisData.getExpireTime();
        //未过期直接返回，已过期缓存重建
        if (expireTime.isAfter(LocalDateTime.now())){
            return shop;
        }
        //过期，先去获取互斥锁，失败返回店铺，成功开启线程执行重建并返回
        String lockKey = LOCK_SHOP_KEY + id;
        boolean isLock = tryGetLock(lockKey);
        if (isLock){
            //成功，独立线程缓存重建
            CACHE_REBUILD_EXECUTOR.submit(() ->{
                try {
                    this.saveShop2Redis(id, 30L);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    //释放锁
                    unLock(lockKey);
                }
            });
        }
        //3redis中为null，根据id查询数据库
        //5存在写入redis并返回
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(shop), CACHE_SHOP_TTL, TimeUnit.MINUTES);
        return shop;
    }
}
