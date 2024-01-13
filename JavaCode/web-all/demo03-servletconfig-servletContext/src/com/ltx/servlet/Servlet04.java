package com.ltx.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * ClassName: Servlet04
 * Package:com.ltx.servlet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/10 15:08
 */
@WebServlet("/servlet04")
public class Servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //行、头、体
        System.out.println(req.getMethod());
        System.out.println(req.getScheme());//获取协议
        System.out.println(req.getProtocol());//获取版本号
        System.out.println(req.getRequestURL());//统一资源定位符
        System.out.println(req.getRequestURI());//统一资源标识符
        System.out.println(req.getRemotePort());//客户端端口号
        System.out.println(req.getServerPort());//客户端发请求时的端口号（可能存在代理）
        //头
        System.out.println(req.getHeader("Accept"));
        Enumeration<String> headerNames = req.getHeaderNames();
        //请求体
    }
}
