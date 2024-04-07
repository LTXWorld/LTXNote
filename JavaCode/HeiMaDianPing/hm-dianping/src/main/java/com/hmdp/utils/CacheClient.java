package com.hmdp.utils;

import cn.hutool.core.lang.func.Func;
import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.hmdp.entity.Shop;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.hmdp.utils.RedisConstants.*;

/**
 * ClassName: CacheClient
 * Package:com.hmdp.utils
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/4/7 17:02
 */
@Slf4j
@Component
public class CacheClient {

    private final StringRedisTemplate stringRedisTemplate;

    public CacheClient(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * TTL过期
     * @param key
     * @param value
     * @param time
     * @param unit
     */
    public void set(String key, Object value, Long time, TimeUnit unit){
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(value), time, unit);
    }

    /**
     * 写值并设置逻辑过期
     * @param key
     * @param value
     * @param time
     * @param unit
     */
    public void setWithLogicalExpire(String key, Object value, Long time, TimeUnit unit){
        //设置逻辑过期
        RedisData redisData = new RedisData();
        redisData.setData(value);
        redisData.setExpireTime(LocalDateTime.now().plusSeconds(unit.toSeconds(time)));
        //写入redis
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(redisData));
    }


    /**
     * @param keyPrefix 前缀，需要用户传过来
     * @param id 根据id查数据库,也是泛型
     * @param type 告知将来要返回什么类型的数据
     * @param dbFallBack 用户传来的操作数据库的逻辑,函数式编程
     * @return
     * @param <R> 泛型，返回的对象类型不一定
     */
    public <R,ID> R queryWithPassThrough(String keyPrefix, ID id, Class<R> type, Function<ID, R> dbFallBack,
                                         Long time, TimeUnit timeUnit) {
        String key = keyPrefix + id;
        //1查询redis中的商铺缓存
        String json = stringRedisTemplate.opsForValue().get(key);
        //2存在直接返回
        if (StrUtil.isNotBlank(json)) {//isNotBlank这个方法意味着只有shopJSON有数据时才会返回true
            return JSONUtil.toBean(json, type);
        }
        //从上面下来就剩两种情况：null或者空字符串
        if (json != null) {
            return null;//这里意味着是空字符串"",
        }
        //3redis中为null，根据id查询数据库,但是工具类不知道如何查（因为类型不确定）
        R r = dbFallBack.apply(id);
        if (r == null) {
            //4数据库中也没有，并且使用缓存空对象来避免缓存穿透
            stringRedisTemplate.opsForValue().set(key, "", CACHE_NULL_TTL, TimeUnit.MINUTES);//将空值写入redis当中
            return null;
        }
        //5存在写入redis并返回
        this.set(key, r, time, timeUnit);
        return r;
    }

    private static final ExecutorService CACHE_REBUILD_EXECUTOR = Executors.newFixedThreadPool(10);



    public <R, ID> R queryWithLogicalExpire(String keyPrefix, ID id, Class<R> type, Function<ID, R> dbFallBack,
                                            Long time, TimeUnit timeUnit) {
        String key = keyPrefix + id;
        //1查询redis中的商铺缓存
        String shopJSON = stringRedisTemplate.opsForValue().get(key);
        //2不存在直接返回
        if (StrUtil.isBlank(shopJSON)) {
            return null;
        }
        //存在，需要判断是否过期
        //先把json反序列化为对象，拿出其中的逻辑过期时间判断是否过期
        RedisData redisData = JSONUtil.toBean(shopJSON, RedisData.class);//获取一个更广泛的从Redis中检索到的数据集，此例包含时间和对象
        R r = JSONUtil.toBean((JSONObject) redisData.getData(), type);//拿到其中存储的数据，格式为JSON。真正的对象r
        LocalDateTime expireTime = redisData.getExpireTime();
        //未过期直接返回，已过期缓存重建
        if (expireTime.isAfter(LocalDateTime.now())){
            return r;
        }
        //过期，先去获取互斥锁，失败返回店铺，成功开启线程执行重建并返回
        String lockKey = LOCK_SHOP_KEY + id;
        boolean isLock = tryGetLock(lockKey);
        if (isLock){
            //成功，独立线程缓存重建
            CACHE_REBUILD_EXECUTOR.submit(() ->{
                try {
                    //查数据库
                    R r1 = dbFallBack.apply(id);
                    //改缓存
                    this.setWithLogicalExpire(key, r1, time, timeUnit);
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
        return r;
    }
    private void unLock(String key){
        stringRedisTemplate.delete(key);
    }
    private boolean tryGetLock(String key){
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(key, "1", 10, TimeUnit.SECONDS);
        return BooleanUtil.isTrue(flag);
    }
}
