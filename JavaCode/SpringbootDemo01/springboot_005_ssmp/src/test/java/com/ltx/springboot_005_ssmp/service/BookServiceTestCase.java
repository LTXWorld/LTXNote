package com.ltx.springboot_005_ssmp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: BookServiceTestCase
 * Package:com.ltx.springboot_005_ssmp.service
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/20 16:03
 */
@SpringBootTest
public class BookServiceTestCase {

    @Autowired
    private BookService bookService;
    @Test
    void testGetById(){
        System.out.println(bookService.getById(5));
    }
}
