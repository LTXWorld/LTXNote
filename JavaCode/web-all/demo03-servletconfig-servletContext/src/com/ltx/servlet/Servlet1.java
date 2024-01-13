package com.ltx.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.Enumeration;

/**
 * ClassName: Servlet1
 * Package:com.ltx.servlet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/8 16:49
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig servletConfig = super.getServletConfig();
        //根据参数名获取参数值
        String key = servletConfig.getInitParameter("key");
        System.out.println(key);

        //
        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext1 = servletConfig.getServletContext();//底层实质是config调用的context

        String encoding = servletContext.getInitParameter("encoding");
        System.out.println(encoding);
        Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
        servletContext1.setAttribute("ka","aaa");
        //String ka = (String)servletContext1.getAttribute("ka");

    }
}
