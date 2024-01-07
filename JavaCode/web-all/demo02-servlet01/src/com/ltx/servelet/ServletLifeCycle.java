package com.ltx.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: ServletLifeCycle
 * Package:com.ltx.servelet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/7 20:52
 *
 *
 *
 * Tomcat会为我们创建收回对象
 * 实例化、初始化、接收请求、处理请求、销毁
 */
@WebServlet("/servletLifeCycle")
public class ServletLifeCycle extends HttpServlet {
    public ServletLifeCycle(){
        System.out.println("1构造器");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("2初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("3服务");
    }

    @Override
    public void destroy() {
        System.out.println("4销毁");
    }
}
