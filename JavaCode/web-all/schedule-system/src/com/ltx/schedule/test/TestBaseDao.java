package com.ltx.schedule.test;

import com.ltx.schedule.dao.BaseDao;
import com.ltx.schedule.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: TestBaseDao
 * Package:com.ltx.schedule.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/18 10:20
 */
public class TestBaseDao {
    private static BaseDao baseDao;
    @BeforeClass
    public static void initBaseDao(){
        baseDao = new BaseDao();
    }
    @Test
    public void testBaseQueryObject(){
        String sql ="select count(1) from sys_user";
        Long count = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(count);
    }
    @Test
    public void testBaseQuery(){
        String sql = "select uid,username,user_pwd UserPwd from sys_user";
        List<SysUser> sysUsersList = baseDao.baseQuery(SysUser.class, sql);
        sysUsersList.forEach(System.out::println);
    }
}
