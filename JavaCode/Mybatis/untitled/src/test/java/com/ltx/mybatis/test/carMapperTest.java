package com.ltx.mybatis.test;

import com.ltx.mybatis.mapper.CarMapper;
import com.ltx.mybatis.pojo.Car;
import com.ltx.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * ClassName: carMapperTest
 * Package:com.ltx.mybatis.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/29 19:47
 */
public class carMapperTest {
    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //面向接口获得接口的代理对象
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.insert(new Car());
    }
}
