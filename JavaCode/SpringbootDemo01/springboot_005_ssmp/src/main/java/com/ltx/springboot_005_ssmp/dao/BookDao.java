package com.ltx.springboot_005_ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ltx.springboot_005_ssmp.domain.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClassName: BookDao
 * Package:com.ltx.springboot_005_ssmp.dao
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/20 14:54
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
