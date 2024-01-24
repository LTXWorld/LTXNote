package com.ltx.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName: loginFilter
 * Package:com.ltx.filter
 * Description:
 *日志过滤器，记录请求的历史，将日志打印到控制台上
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/24 10:25
 */
public class loginFilter implements Filter {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /*
    请求到达目标资源之前先经过该方法
    该方法可以控制是否可以到达目标资源
    资源响应前还要经过此方法（不能停止响应）
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //到达之前的控制判断代码并打印日志
        System.out.println("loggingFilter before doFilter invoked");
        String requestURI = ((HttpServletRequest) servletRequest).getRequestURI();
        String dateTime = dateFormat.format(new Date());
        String beforeLoggin = requestURI + "在" + dateTime + "被访问了";
        System.out.println(beforeLoggin);
        long t1 = System.currentTimeMillis();
        //放行代码,其中存在着过滤器链
        filterChain.doFilter(servletRequest,servletResponse);
        //响应之前的功能代码
        long t2 = System.currentTimeMillis();
        System.out.println("logging after filterChain.doFilter invoked");
        String afterLogging = requestURI + "资源在" + dateTime + "的请求耗时：" +(t2-t1) + "毫秒";
    }
}
