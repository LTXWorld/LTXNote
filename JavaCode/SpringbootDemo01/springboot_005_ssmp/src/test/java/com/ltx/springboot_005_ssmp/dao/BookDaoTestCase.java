package com.ltx.springboot_005_ssmp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ltx.springboot_005_ssmp.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * ClassName: BookDaoTestCase
 * Package:com.ltx.springboot_005_ssmp.dao
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/20 14:55
 */
@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;
    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }
    //分页操作
    @Test
    void testGetPage(){
        IPage page = new Page(1, 5);//显示第一页的5条数据
        bookDao.selectPage(page, null);
    }

    //条件查询
    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "Spring");
        //select * from tb where name like %Spring%
        bookDao.selectList(qw);
        //
        String name = null;
        LambdaQueryWrapper<Book> Lqw = new LambdaQueryWrapper<>();
        Lqw.like(name != null, Book::getName, "Spring");
        bookDao.selectList(Lqw);
    }
}
