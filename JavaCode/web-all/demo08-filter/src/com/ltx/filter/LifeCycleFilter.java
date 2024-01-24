package com.ltx.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * ClassName: LifeCycleFilter
 * Package:com.ltx.filter
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/24 11:01
 */
public class LifeCycleFilter implements Filter {
    //生命周期
    public LifeCycleFilter(){
        System.out.println("构造");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //2初始化，配置信息需要在xml中配置
        System.out.println(filterConfig.getInitParameter("dataTimePattern"));
    }
    //3过滤
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤方法");

        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {
        System.out.println("4销毁方法");
    }
}
