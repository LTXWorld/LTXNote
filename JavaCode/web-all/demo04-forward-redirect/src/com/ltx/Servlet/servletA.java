package com.ltx.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: servletA
 * Package:com.ltx.Servlet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/13 19:37
 */
@WebServlet("/servletA")
public class servletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA执行了");

        String money = req.getParameter("money");
        System.out.println("A获得money" + money);
        //请求转发给B
        //获得转发对象
//        RequestDispatcher servletB = req.getRequestDispatcher("servletB");
        RequestDispatcher servletB = req.getRequestDispatcher("a.html");
        //转发请求req和resp对象
        servletB.forward(req,resp);
    }
}
