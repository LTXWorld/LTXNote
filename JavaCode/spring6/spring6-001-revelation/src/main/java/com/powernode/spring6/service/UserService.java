package com.powernode.spring6.service;

import com.powernode.spring6.dao.UserDao;

/**
 * ClassName: UserService
 * Package:com.powernode.spring6.service
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/6 09:51
 */
public class UserService {
    private UserDao userDao;
    //使用set注入，给userDao属性赋值。使用IDEA工具生成，符合javaBean规范
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser(){
        userDao.insert();
    }
}
