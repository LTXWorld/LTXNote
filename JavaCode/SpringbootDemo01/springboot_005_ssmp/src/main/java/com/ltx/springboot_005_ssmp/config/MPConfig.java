package com.ltx.springboot_005_ssmp.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: MPConfig
 * Package:com.ltx.springboot_005_ssmp.config
 * Description:
 *MP的拦截器配置
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/20 15:17
 */
@Configuration
public class MPConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //创建一个拦截器壳子，里面放入不同的拦截器（分页拦截器）；最后返回拦截器壳子
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }
}
