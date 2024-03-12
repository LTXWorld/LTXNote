package com.ltx.myspringTest;

import org.junit.Test;
import org.myspringframework.core.ApplicationContext;
import org.myspringframework.core.ClassPathXmlApplicationContext;

/**
 * ClassName: myspringTest
 * Package:com.ltx.myspringTest
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/11 16:22
 */
public class myspringTest {
    @Test
    public void testMySpring(){
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("myspring.xml");

    }
}
