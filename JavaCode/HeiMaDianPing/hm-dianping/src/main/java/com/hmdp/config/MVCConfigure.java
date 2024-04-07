package com.hmdp.config;

import com.hmdp.utils.LoginInterceptor;
import com.hmdp.utils.RefreshTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * ClassName: WebMVCConfigure
 * Package:com.hmdp.config
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/4/5 20:18
 */
@Configuration
public class MVCConfigure implements WebMvcConfigurer {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns(//这里在做拦截器的放行
                        "/user/code",
                        "/user/login",
                        "/blog/hot",
                        "/shop/**",
                        "/shop-type/**",
                        "/voucher/**"
                ).order(1);//order值越大执行优先级越低
        registry.addInterceptor(new RefreshTokenInterceptor(stringRedisTemplate)).order(0);//拦截所有请求，并且需要先执行
    }
}
