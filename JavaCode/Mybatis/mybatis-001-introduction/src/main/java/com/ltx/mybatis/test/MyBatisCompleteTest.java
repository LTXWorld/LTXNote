package com.ltx.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * ClassName: MyBatisCompleteTest
 * Package:com.ltx.mybatis.test
 * Description:
 *完整版的mybatis程序
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/23 13:52
 */
public class MyBatisCompleteTest {
    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = sqlSessionFactory.openSession();
            //执行sql语句处理相关业务
            int count = sqlSession.insert("insertCar");
            System.out.println(count);
            //没有发生异常则提交事务
            sqlSession.commit();
        } catch (Exception e) {
            //如果出现异常，回滚事务
            if (sqlSession != null){
                sqlSession.rollback();
            }
            e.printStackTrace();
        }finally {
            //关闭会话
            if (sqlSession != null){
                sqlSession.close();
            }
        }
    }
}
