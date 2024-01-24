package com.ltx.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * ClassName: Servlet1
 * Package:com.ltx.servlet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/23 21:15
 */
public class Servlet1 extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //向请求域存储
        req.setAttribute("request","requestMessage");
        //会话
        HttpSession session = req.getSession();
        session.setAttribute("session","sessionMessage");
        //应用
        ServletContext application = getServletContext();
        application.setAttribute("application","applicationMessage");
    }
}
