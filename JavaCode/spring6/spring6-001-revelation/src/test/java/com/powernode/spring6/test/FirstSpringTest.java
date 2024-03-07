package com.powernode.spring6.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName: FirstSpringTest
 * Package:com.powernode.spring6.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/5 21:36
 */
public class FirstSpringTest {
    @Test
    public void testFirstSpringCode(){
        //1获取spring容器对象
        //ApplicationContext是一个接口，class是其其中一个实现类
        //ClassPathXmlApplicationContext从类路径中加载spring配置文件的一个上下文对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //启动了spring容器，解析spring.xml文件，并且实例化所有bean对象，放到容器当中。

        //2根据bean的id从spring容器中获取实例对象
        Object userBean = applicationContext.getBean("UserBean");
        System.out.println(userBean);
        //
    }
}
