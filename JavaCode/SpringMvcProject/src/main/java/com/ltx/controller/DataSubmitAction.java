package com.ltx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ltx.pojo.User;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: DataSubmitAction
 * Package:com.ltx.controller
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/17 10:35
 */
@Controller
public class DataSubmitAction {
    @RequestMapping("/one")
    public String one(String myname, int age){
        System.out.println("myname=" + myname + ",age=" + (age + 100));
        return "main";
    }
    @RequestMapping("/two")
    public String two(User user){
        System.out.println(user);
        return "main";
    }
    @RequestMapping("/three/{name}/{age}")
    public String three(@PathVariable String name, @PathVariable int age){
        System.out.println("name" + name + ",age=" + (age + 100));
        return "main";
    }
    @RequestMapping("/four")
    public String four(@RequestParam("name") String uname,
                       @RequestParam("age") int uage){
        System.out.println("uname=" + uname+",uage" + uage);
        return "main";
    }
}
