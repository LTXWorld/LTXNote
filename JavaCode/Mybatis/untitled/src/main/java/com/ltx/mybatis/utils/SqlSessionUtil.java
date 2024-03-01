package com.ltx.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

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

    //获取会话对象
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}
