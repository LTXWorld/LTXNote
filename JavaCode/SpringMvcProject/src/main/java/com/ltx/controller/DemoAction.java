package com.ltx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: DemoAction
 * Package:com.ltx.controller
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/17 09:29
 */
@Controller
public class DemoAction {
    @RequestMapping("/demo")
    public String demo(){
        System.out.println("服务器被访问了");
        return "main";//可以跳转到/admin/main.jsp页面上
    }
}
