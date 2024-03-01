package com.ltx.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

/**
 * ClassName: ConfigurationTest
 * Package:com.ltx.mybatis.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/21 20:41
 */
public class ConfigurationTest {
    @Test
    public void testEnvironment() throws Exception{
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //两种调用数据库（环境）的方式，第一个使用默认环境，第二个使用指定环境id来获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream(""));
        SqlSessionFactory sqlSessionFactory1 = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream(""), "powernode");
    }
}
