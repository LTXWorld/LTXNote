package com.hmdp.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * ClassName: RedisWorker
 * Package:com.hmdp.utils
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/4/8 08:59
 */
@Component
public class RedisIDWorker {

    private static final long BEGIN_TIMESTAMP = 1640995200L;//开始的时间戳
    private static final int COUNT_BITS = 32;//序列号的位数

    private StringRedisTemplate stringRedisTemplate;

    public RedisIDWorker(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 生成全局唯一id，符号位+时间戳+序列号
     * @param keyPrefix 业务前缀，区分不同业务
     * @return
     */
    public long nextId(String keyPrefix){
        //生成时间戳:当前时间(秒）- 开始的时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        long timestamp =  nowSecond - BEGIN_TIMESTAMP;

        //生成序列号，利用redis的自增长,并拼接日期字符串，可以区分，统计某天的订单
        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        Long count = stringRedisTemplate.opsForValue().increment("icr:" + keyPrefix + ":" + date);
        //拼接返回,因为返回的不是字符串而是long类型，所以需要进行移位拼接而不是简单的拼接。

        return timestamp << COUNT_BITS | count;//先将时间戳左移留出序列号位置，再使用或运算
    }
}
