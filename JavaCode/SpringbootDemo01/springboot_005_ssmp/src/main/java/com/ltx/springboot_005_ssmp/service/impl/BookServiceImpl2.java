package com.ltx.springboot_005_ssmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ltx.springboot_005_ssmp.dao.BookDao;
import com.ltx.springboot_005_ssmp.domain.Book;
import com.ltx.springboot_005_ssmp.service.IBookService;
import org.springframework.stereotype.Service;

import java.security.Provider;

/**
 * ClassName: BookServiceImpl2
 * Package:com.ltx.springboot_005_ssmp.service.impl
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/20 16:13
 */
@Service
public class BookServiceImpl2 extends ServiceImpl<BookDao, Book> implements IBookService {

}
