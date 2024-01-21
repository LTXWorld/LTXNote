package com.ltx.schedule.controller;

import com.ltx.schedule.pojo.SysUser;
import com.ltx.schedule.service.SysUserService;
import com.ltx.schedule.service.impl.SysUserServiceImpl;
import com.ltx.schedule.util.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * ClassName: SysUserController
 * Package:com.ltx.schedule.controller
 * Description:
 *控制层作为桥梁，继承Servlet使用Servlet技术规范；调用service层中的方法来对传来的信息做预处理并返回用户页面
 * 将重复操作集成在BaseController中，使多个表的各自请求去继承同一个BaseController
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/18 11:06
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {

    private SysUserService userService = new SysUserServiceImpl();//

    /**
     *接收用户注册请求的处理方法（接口）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        //调用服务端方法，完成注册功能;将参数放入sysuser对象中，传入到服务层的regist方法中
        SysUser sysUser = new SysUser(null,username,userPwd);
        int rows = userService.regist(sysUser);
        //根据注册结果进行页面跳转返回给用户，使用重定向
        if (rows > 0){
            resp.sendRedirect("/registerSuccess.html");
        }else {
            resp.sendRedirect("/registerFail.html");
        }
        //
    }

    /**
     * 完成登录的桥梁（业务接口）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收用户名和密码
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        //调用服务层方法查询用户信息看是否存在
        SysUser loginUser = userService.findByUsername(username);
        if (loginUser == null){
            resp.sendRedirect("/loginUsernameError.html");
            //如果用户信息存在，判断密码是否一致
        }else if (!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())){
            resp.sendRedirect("/loginUserPwdError.html");
        }else {
            //登录成功跳转到首页
            resp.sendRedirect("/showSchedule.html");
        }

    }
}
