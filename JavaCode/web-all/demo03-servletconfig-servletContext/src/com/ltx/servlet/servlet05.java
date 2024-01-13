package com.ltx.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * ClassName: servlet05
 * Package:com.ltx.servlet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/10 15:27
 */
@WebServlet("/servlet05")
public class servlet05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取键值对,key=value无论是post还是get
        String username = req.getParameter("username");
        System.out.println(username);
        System.out.println(req.getParameter("userPwd"));
        //根据参数名获得多个参数值
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        //返回所有参数的map集合,不论是单值还是多值
        Map<String, String[]> parameterMap = req.getParameterMap();
        //获取请求体中的非键值对，读取字符输入流
        BufferedReader reader = req.getReader();
        //读取二进制字节流，读文件
        ServletInputStream inputStream = req.getInputStream();
    }
}
