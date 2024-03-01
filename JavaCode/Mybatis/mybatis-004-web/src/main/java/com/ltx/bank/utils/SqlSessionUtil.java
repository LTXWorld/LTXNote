package com.ltx.bank.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.lang.invoke.VarHandle;

/**
 * ClassName: SqlSessionUtil
 * Package:com.ltx.mybatis.utils
 * Description:
 *提供一个工具类
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/23 14:53
 */
public class SqlSessionUtil {
    /**
     * 构造方法私有化，提供其他的静态方法
     */
    private SqlSessionUtil(){}

    private static SqlSessionFactory sqlSessionFactory;
    //静态代码块，类加载时执行，因为SqlSessionFactory对应一个数据库，不需要声明多次
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //全局的，一个服务器定义一个ThreadLocal
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    //获取会话对象
    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();
        if (sqlSession == null){
             sqlSession = sqlSessionFactory.openSession();
             //第一次拿到sqlsession后绑定到当前线程上
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭sqlsession对象
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        if (sqlSession != null){
            sqlSession.close();
            //防止这个线程再次被其他人调用
            local.remove();//从当前线程中解绑，移除sqlSession对象
        }
    }
}
