package com.ltx.bank.service.impl;

import com.ltx.bank.dao.AccountDao;
import com.ltx.bank.dao.impl.AccountDaoImpl;
import com.ltx.bank.exceptions.MoneyNotEnoughException;
import com.ltx.bank.exceptions.TransferException;
import com.ltx.bank.pojo.Account;
import com.ltx.bank.service.AccountService;
import com.ltx.bank.utils.GenerateDaoProxy;
import com.ltx.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * ClassName: AccountServiceimpl
 * Package:com.ltx.bank.service.impl
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/22 18:32
 */
public class AccountServiceimpl implements AccountService {
//   private AccountDao accountDao = new AccountDaoImpl();
   private AccountDao accountDao = SqlSessionUtil.openSession().getMapper(AccountDao.class);
//    private AccountDao accountDao = (AccountDao) GenerateDaoProxy.generate(SqlSessionUtil.openSession(), AccountDao.class);
    @Override
    public void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException {

        //添加事务控制代码
        SqlSession sqlSession = SqlSessionUtil.openSession();

        //具体实现,Mybatis应用在这里,但是数据库的crud操作应该在dao包里面去做
        //1判断转出账户余额是否充足(select)
        Account fromAct = accountDao.selectByActno(fromActno);
        Double balance = fromAct.getBalance();
        if (balance < money){//2如果账户余额不够，提示用户
            //抛出异常类
            throw new MoneyNotEnoughException("对不起，余额不足");
        }
        //3如果转出账户余额充足，更新余额(update)
        //先更新内存中java对象account的余额，然后更新数据库
        Account toAct = accountDao.selectByActno(toActno);
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);
        //4更新余额
        int count = accountDao.updateByActno(fromAct);
        count += accountDao.updateByActno(toAct);
        if (count != 2){
            throw new TransferException("转账异常，未知原因");
        }

        //提交并关闭事务
        sqlSession.commit();

        SqlSessionUtil.close(sqlSession);
    }
}
