package com.ltx.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ClassName: Servlet3
 * Package:com.ltx.servlet
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/10 11:52
 */
@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //向upload中写入文件
        ServletContext servletContext = getServletContext();
        String path = servletContext.getRealPath("upload");//获取此项目部署位置下的某个文件的磁盘真是路径，动态路径没有写死
        System.out.println(path);
        FileOutputStream fos = new FileOutputStream(path+"/a.txt");
        //获取项目上下文路径（浏览器里面那个）
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        //从域对象中读取数据
        ServletContext servletContext1 = getServletContext();
        String ka = (String)servletContext1.getAttribute("ka");
        System.out.println(ka);
    }
}
