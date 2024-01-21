package com.ltx.schedule.dao;

import com.ltx.schedule.pojo.SysUser;

/**
 * ClassName: SysUserDao
 * Package:com.ltx.schedule.dao
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/15 19:23
 * 数据访问对象
 * 定义针对表格的crud方法
 * 针对每一个表格都有一个独立的dao实体类封装crud方法
 * dao层需要定义接口和实现类
 */
public interface SysUserDao {
    /**
     * 向数据库中增加一条用户记录的方法
     * @param sysUser
     * @return 增加成功返回1，失败返回0
     */
    int addUser(SysUser sysUser);

    /**
     * 返回username对应的对象
     * @param username
     * @return 如果没有则返回null，如果有返回对应对象
     */
    SysUser findByName(String username);
}
