package com.ltx.springboot_005_ssmp.service;

import org.springframework.stereotype.Service;
import com.ltx.springboot_005_ssmp.domain.Book;

import java.util.List;

/**
 * ClassName: BookService
 * Package:com.ltx.springboot_005_ssmp.service
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/20 15:39
 */
public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
}
