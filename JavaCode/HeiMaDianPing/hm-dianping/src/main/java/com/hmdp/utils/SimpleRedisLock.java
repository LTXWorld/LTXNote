package com.hmdp.utils;

import cn.hutool.core.lang.UUID;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * ClassName: SimpleRedisLock
 * Package:com.hmdp.utils
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/4/8 16:16
 */
public class SimpleRedisLock implements ILock{

    private static final String KEY_PREFIX = "lock:";
    private static final String ID_PREFIX = UUID.randomUUID().toString(true) + "-";

    //需要调用者传递锁的名称和stringRedisTemplate
    private StringRedisTemplate stringRedisTemplate;
    private String name;

    public SimpleRedisLock(StringRedisTemplate stringRedisTemplate, String name) {
        this.stringRedisTemplate = stringRedisTemplate;
        this.name = name;
    }


    @Override
    public boolean tryLock(long timeoutSec) {
        //获取线程标识
        String threadId = ID_PREFIX + Thread.currentThread().getId();
        //获取锁
        Boolean success = stringRedisTemplate.opsForValue()
                .setIfAbsent(KEY_PREFIX + name, threadId, timeoutSec, TimeUnit.SECONDS);
        return Boolean.TRUE.equals(success);//防止自动拆箱空指针问题
    }

    @Override
    public void unlock() {
        //判断锁是否是自己的，需要线程标识
        String threadId = ID_PREFIX + Thread.currentThread().getId();
        //
        String id = stringRedisTemplate.opsForValue().get(KEY_PREFIX + name);
        if (threadId.equals(id)){
            //判断线程id是否与锁中的id一致
            stringRedisTemplate.delete(KEY_PREFIX + name);
        }
    }
}
