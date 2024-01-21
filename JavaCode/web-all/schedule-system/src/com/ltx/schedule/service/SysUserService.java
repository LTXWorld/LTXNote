package com.ltx.schedule.service;

import com.ltx.schedule.pojo.SysUser;

/**
 * ClassName: SysUserService
 * Package:com.ltx.schedule.service
 * Description:
 *定义了以sys_user表格为核心的业务处理功能
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/18 10:59
 */
public interface SysUserService {
    /**
     * 注册用户的方法
     * @param sysUser 要注册的用户（内有用户名和明文密码）
     * @return 注册成功返回1，注册失败返回0
     */
    int regist(SysUser sysUser);

    /**
     * 根据用户名获得完整的用户信息的方法
     * @param username
     * @return 如果找到了返回sysUser对象，如果找不到返回null
     */
    SysUser findByUsername(String username);
}
