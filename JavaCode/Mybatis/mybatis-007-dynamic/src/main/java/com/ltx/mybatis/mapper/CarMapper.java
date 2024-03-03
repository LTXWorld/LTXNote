package com.ltx.mybatis.mapper;

import com.ltx.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

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
    List<Car> selectIfMulti(@Param("brand") String brand, @Param("guide_price") Double guide_price, @Param("carType") String carType);
}
