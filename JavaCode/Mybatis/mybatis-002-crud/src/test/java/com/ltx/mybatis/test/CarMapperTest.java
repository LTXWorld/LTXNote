package com.ltx.mybatis.test;

import com.ltx.mybatis.utils.SqlSessionUtil;
import com.ltx.mybatis.yojo.Car;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Objects;

/**
 * ClassName: CarMapperTest
 * Package:com.ltx.mybatis.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/23 15:22
 */
public class CarMapperTest {
    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car();
        int count = sqlSession.update("updateById", car);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDeleteCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //
        int count = sqlSession.delete("deleteById", 59);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //这里insert里面就可以传对象了，不只是单纯的sql语句标志，半自动化orm
        HashMap<String, Object> map = new HashMap<>();
        map.put("carNum", "1111");
        map.put("carName","byd");
        map.put("carPrice", 10.0);
        map.put("carData", "2020-11-11");
        map.put("carType","电车");
        sqlSession.insert("insertCar",map);
        sqlSession.commit();
        sqlSession.close();
    }
}
