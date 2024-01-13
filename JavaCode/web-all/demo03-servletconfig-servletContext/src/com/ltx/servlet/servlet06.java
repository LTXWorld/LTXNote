package com.ltx.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: servlet06
 * Package:com.ltx.servlet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/10 15:44
 */
@WebServlet("/servlet06")
public class servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应行状态码
        resp.setStatus(404);
        //响应头
        resp.setHeader("aaa","valuea");
        resp.setHeader("Content-Type","text/html");
        resp.setContentType("text/html");
        resp.setContentLength(1500);
        //响应体
        PrintWriter writer = resp.getWriter();
        writer.write(123);
    }
}
