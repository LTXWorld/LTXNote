package com.ltx.schedule.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

/**
 * ClassName: SysUserController
 * Package:com.ltx.schedule.controller
 * Description:
 *控制层作为桥梁，继承Servlet使用Servlet技术规范
 * 将重复操作集成在BaseController中，使多个表的各自请求去继承同一个BaseController
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/18 11:06
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {
}
