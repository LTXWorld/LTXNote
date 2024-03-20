package com.ltx.springbootdemo02;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: BookController
 * Package:com.ltx.springbootdemo02
 * Description:
 * Rest模式
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/18 16:26
 */
@RestController
@RequestMapping("/books")
public class BookController {
    @GetMapping
    public String getById(){
        System.out.println("springboot is running");
        return "springboot";
    }
}
