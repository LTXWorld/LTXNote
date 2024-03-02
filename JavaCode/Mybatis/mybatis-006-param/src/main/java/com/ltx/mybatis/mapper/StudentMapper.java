package com.ltx.mybatis.mapper;

import com.ltx.mybatis.pojo.Student;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ClassName: StudentMapper
 * Package:com.ltx.mybatis.mapper
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/1 16:07
 */
public interface StudentMapper {
    @MapKey("id")//将查询结果的id作为整个Map集合的key
    Map<Long, Map<String, Object>> selectAllRetMap();
    List<Student> selectByNameAndSex2(@Param("name") String name, @Param("sex") Character sex);
    /**
     * 虽然是单个参数，但是参数类型是Map集合
     * @param map
     * @return
     */
    int insertStudentByMap(Map<String, Object> map);
    /**
     * 接口的方法参数只有一个（单个参数）并且参数的数据类型都是简单类型
     */
    List<Student> selectById(Long id);
    List<Student> selectByName(String name);
    List<Student> selectByBirth(Date birth);
    List<Student> selectBySex(Character sex);
}
