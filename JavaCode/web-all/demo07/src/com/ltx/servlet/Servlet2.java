package com.ltx.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * ClassName: Servlet2
 * Package:com.ltx.servlet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/23 21:22
 */
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从三大域中取出数据
        String reqMessage = (String)req.getAttribute("request");
        System.out.println(reqMessage);

        HttpSession session = req.getSession();
        String sessionMessage =  (String)session.getAttribute("session");
        System.out.println(sessionMessage);

        ServletContext application = getServletContext();
        String appMessage = (String) application.getAttribute("application");
        System.out.println(appMessage);
    }
}
