package com.ltx.springboot_005_ssmp.service.impl;

import com.ltx.springboot_005_ssmp.dao.BookDao;
import com.ltx.springboot_005_ssmp.domain.Book;
import com.ltx.springboot_005_ssmp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: BookServiceImpl
 * Package:com.ltx.springboot_005_ssmp.service.impl
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/20 15:43
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }
}
