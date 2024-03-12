package com.ltx.myspring.bean;

/**
 * ClassName: UserService
 * Package:com.ltx.myspring.bean
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/11 15:34
 */
public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.insert();
    }
}
