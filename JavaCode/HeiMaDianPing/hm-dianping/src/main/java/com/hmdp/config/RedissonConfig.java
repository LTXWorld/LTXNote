package com.hmdp.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: RedissonConfig
 * Package:com.hmdp.config
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/4/9 10:01
 */
@Configuration
public class RedissonConfig {

    //将redisson客户端创建好交由spring管理
    @Bean
    public RedissonClient redissonClient(){
        //配置
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setPassword("123321");
        //创建Redisson对象
        return Redisson.create(config);
    }
}
