package com.ltx.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: servletB
 * Package:com.ltx.Servlet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/13 19:38
 */
@WebServlet("/servletB")
public class servletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletB执行了");

        String money = req.getParameter("money");
        System.out.println("A获得money" + money);
    }
}
