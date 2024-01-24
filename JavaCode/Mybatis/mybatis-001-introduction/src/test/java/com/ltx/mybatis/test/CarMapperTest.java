package com.ltx.mybatis.test;

import com.ltx.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * ClassName: CarMapperTest
 * Package:com.ltx.mybatis.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/23 14:21
 */
public class CarMapperTest {
    @Test
    public void testInsertCatByUtil(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //
        sqlSession.insert("insertCar");
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertCar(){
        //编写mybatis语句，可以有期望值和实际值
    }
}
