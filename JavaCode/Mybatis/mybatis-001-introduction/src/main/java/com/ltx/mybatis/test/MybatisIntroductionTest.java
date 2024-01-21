package com.ltx.mybatis.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * ClassName: MybatisIntroductionTest
 * Package:com.ltx.mybatis.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/20 10:07
 */
public class MybatisIntroductionTest {
    public static void main(String[] args) throws Exception {
        //获取builder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取Factory对象
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");//默认从类的根路径查找资源
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);//输入流指向核心配置文件
        //获取session对象，以此来执行sql语句
        SqlSession sqlSession = sqlSessionFactory.openSession();//默认为false
        //执行sql语句,返回影响数据库表中的记录条数
        try {
            // 执行sql语句
            int count = sqlSession.insert("insertCar");
            System.out.println(count);
            // 提交事务
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback(); // 发生异常，回滚事务
            throw e;
        } finally {
            sqlSession.close(); // 最终关闭会话
        }
    }
}
