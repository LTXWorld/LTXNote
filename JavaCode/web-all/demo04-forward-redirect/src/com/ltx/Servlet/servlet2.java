package com.ltx.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: servlet2
 * Package:com.ltx.Servlet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/13 20:18
 */
@WebServlet("/servlet2")
public class servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("2execute");
    }
}
