package com.ltx.bank.dao;

import com.ltx.bank.pojo.Account;

/**
 * ClassName: AccountDao
 * Package:com.ltx.bank.dao
 * Description:
 *账户的dao对象，负责t_account表中的crud
 * Dao对象中的任何一个方法与业务都不挂钩，就是做crud，方法名就是insert、delete、update
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/22 18:38
 */
public interface AccountDao {
    /**
     * 根据账户查询账户信息
     * @param actno 账号
     * @return 账户信息
     */
    Account selectByActno(String actno);

    /**
     * 更新账户信息
     * @param act 被更新的账户对象
     * @return 1表示更新成功
     */
    int updateByActno(Account act);
}
