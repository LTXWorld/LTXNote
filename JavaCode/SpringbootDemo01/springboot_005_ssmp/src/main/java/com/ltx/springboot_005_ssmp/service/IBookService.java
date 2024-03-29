package com.ltx.springboot_005_ssmp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ltx.springboot_005_ssmp.domain.Book;
import org.springframework.stereotype.Service;

/**
 * ClassName: IBookService
 * Package:com.ltx.springboot_005_ssmp.service
 * Description:
 *写接口最好前面以I开头
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/20 16:11
 */
public interface IBookService extends IService<Book> {
    //里面包含了通用方法，save,update,remove等，但是特殊的业务方法需要自己写
}
