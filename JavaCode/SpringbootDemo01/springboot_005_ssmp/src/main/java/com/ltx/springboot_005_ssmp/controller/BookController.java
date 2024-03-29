package com.ltx.springboot_005_ssmp.controller;

import com.ltx.springboot_005_ssmp.domain.Book;
import com.ltx.springboot_005_ssmp.service.BookService;
import com.ltx.springboot_005_ssmp.service.IBookService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ltx.springboot_005_ssmp.service.IBookService;

import java.util.List;

/**
 * ClassName: BookController
 * Package:com.ltx.springboot_005_ssmp.controller
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/20 16:30
 */
//@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookSer;
    @GetMapping
    public List<Book> getAll(){
        return bookSer.list();
    }

    //Rest风格，GET查询，post添加，put修改，delete删除
    @PostMapping
    public Boolean save(Book book){
         return bookSer.save(book);
    }
    @PutMapping
    public Boolean update(Book book){
        return bookSer.updateById(book);
    }
    @DeleteMapping
    public Boolean delete(Integer id){
        return bookSer.removeById(id);
    }
    //查单个
}
