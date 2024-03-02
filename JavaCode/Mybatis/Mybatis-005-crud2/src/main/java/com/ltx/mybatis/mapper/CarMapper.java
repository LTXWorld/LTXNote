package com.ltx.mybatis.mapper;

import com.ltx.mybatis.pojo.Car;

import java.util.List;

/**
 * ClassName: CarMapper
 * Package:com.ltx.mybatis.mapper
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/29 17:23
 */
public interface CarMapper {
    int insertCarUseGeneratedKeys(Car car);
    int insert(Car car);

    int deleteById(Long id);

    int update(Car car);

    Car selectById(Long id);

    List<Car> selectAll();
}
