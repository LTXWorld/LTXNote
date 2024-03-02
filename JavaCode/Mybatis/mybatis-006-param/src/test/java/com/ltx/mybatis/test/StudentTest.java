package com.ltx.mybatis.test;

import com.ltx.mybatis.mapper.StudentMapper;
import com.ltx.mybatis.pojo.Student;
import com.ltx.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: StudentTest
 * Package:com.ltx.mybatis.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/1 16:11
 */
public class StudentTest {
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectById(1L);

    }
}
