package com.ltx.schedule.dao.impl;

import com.ltx.schedule.dao.BaseDao;
import com.ltx.schedule.dao.SysUserDao;
import com.ltx.schedule.pojo.SysUser;

import java.util.List;

/**
 * ClassName: SysUserDaoImpl
 * Package:com.ltx.schedule.dao.impl
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/15 19:29
 */
public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addUser(SysUser sysUser) {
        //在dao层就是数据库的操作语句
        String sql = "insert into sys_user values(DEFAULT,?,?)";
        return baseUpdate(sql,sysUser.getUsername(),sysUser.getUserPwd());
    }

    @Override
    public SysUser findByName(String username) {
        String sql = "select uid, username, user_pwd userPwd from sys_user where username = ?";
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);
        return sysUserList!= null && sysUserList.size()>0 ? sysUserList.get(0) : null;
    }
}
