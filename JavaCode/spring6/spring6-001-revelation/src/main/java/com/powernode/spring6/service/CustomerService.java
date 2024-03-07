package com.powernode.spring6.service;

import com.powernode.spring6.dao.UserDao;

/**
 * ClassName: CustomerService
 * Package:com.powernode.spring6.service
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/6 14:53
 */
public class CustomerService {
    private UserDao userDao;

    public CustomerService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.insert();
    }
}
