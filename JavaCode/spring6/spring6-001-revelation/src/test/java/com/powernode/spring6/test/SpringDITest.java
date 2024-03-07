package com.powernode.spring6.test;

import com.powernode.spring6.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: SpringDITest
 * Package:com.powernode.spring6.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/6 09:54
 */
public class SpringDITest {
    @Test
    public void testDI(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("UserServiceBean", UserService.class);
        userService.saveUser();
    }
}
