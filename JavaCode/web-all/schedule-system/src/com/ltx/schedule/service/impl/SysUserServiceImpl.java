package com.ltx.schedule.service.impl;

import com.ltx.schedule.dao.SysUserDao;
import com.ltx.schedule.dao.impl.SysUserDaoImpl;
import com.ltx.schedule.pojo.SysUser;
import com.ltx.schedule.service.SysUserService;
import com.ltx.schedule.util.MD5Util;

/**
 * ClassName: SysUserServiceImpl
 * Package:com.ltx.schedule.service.impl
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/18 11:01
 */
public class SysUserServiceImpl implements SysUserService {
    private SysUserDao sysUserDao = new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {
        //先将明文密码改为密文密码
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        //将user信息填入数据库,调用dao层的方法操作数据库
        int rows = sysUserDao.addUser(sysUser);
        return rows;
    }

    @Override
    public SysUser findByUsername(String username) {
        SysUser sysUser = sysUserDao.findByName(username);
        return sysUser;
    }
}
