package com.powernode.spring6.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: UserDao
 * Package:com.powernode.spring6.dao
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/6 09:47
 */
public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);
    public void insert(){
        logger.info("数据库保存用户信息");
    }
}
