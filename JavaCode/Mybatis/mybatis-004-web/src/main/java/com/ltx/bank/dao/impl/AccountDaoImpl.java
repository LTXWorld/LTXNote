package com.ltx.bank.dao.impl;

import com.ltx.bank.dao.AccountDao;
import com.ltx.bank.pojo.Account;
import com.ltx.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * ClassName: AccountDaoImpl
 * Package:com.ltx.bank.dao.impl
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/22 18:45
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectByActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = sqlSession.selectOne("account.selectByActno", actno);//这里跟AccountMapper.xml中联动
//        sqlSession.close();
        return account;
    }

    @Override
    public int updateByActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("account.updateByActno",act);//"sqlId",act 两个参数
//        sqlSession.commit();
//        sqlSession.close();
        //为了在service中控制事务，要是同一个sqlSession，使用ThreadLocal
        return count;
    }
}
