package com.ltx.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: servlet1
 * Package:com.ltx.Servlet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/13 20:18
 */
@WebServlet("/servlet1")
public class servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1执行了");
        //响应重定向
        resp.sendRedirect("servlet2");//设置了响应状态码为302，同时设置响应头
    }
}
