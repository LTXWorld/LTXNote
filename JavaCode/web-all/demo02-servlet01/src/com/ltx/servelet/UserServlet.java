package com.ltx.servelet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: UserServlet
 * Package:com.ltx.servelet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/7 16:31
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从客户端传来的Request对象中获得信息
        String username = request.getParameter("username");//根据参数名获取参数值，可能在url或者请求体中
        //处理业务代码
        String info = "<h1>YES</h1>";
        if ("atguigu".equals(username)){
            info = "<h1>NO</h1>";
        }
        //将响应的数据放入Response对象中
        //设置响应头，告诉返回什么类型
        response.setHeader("Content-Type","text/html");
        PrintWriter writer = response.getWriter();//该方法返回的向响应体中打印字符的打印流
        writer.write(info);
    }
}
