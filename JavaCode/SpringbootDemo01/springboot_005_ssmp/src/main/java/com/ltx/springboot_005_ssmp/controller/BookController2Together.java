package com.ltx.springboot_005_ssmp.controller;

import com.ltx.springboot_005_ssmp.controller.utils.R;
import com.ltx.springboot_005_ssmp.domain.Book;
import com.ltx.springboot_005_ssmp.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RestController
@RequestMapping("/books")
public class BookController2Together {
    @Autowired
    private IBookService bookSer;
    @GetMapping
    public R getAll(){
        return new R(true, bookSer.list());
    }

    //Rest风格，GET查询，post添加，put修改，delete删除
    @PostMapping
    public R save(@RequestBody Book book){
        R r = new R(bookSer.save(book));
        return r;
    }
    @PutMapping
    public R update(@RequestBody Book book){
        R r = new R(bookSer.updateById(book));
        return r;
    }
    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        R r = new R(bookSer.removeById(id));
        return r;
    }
    //查单个
}
