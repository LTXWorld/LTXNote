package com.ltx.bank.service;

import com.ltx.bank.exceptions.MoneyNotEnoughException;
import com.ltx.bank.exceptions.TransferException;

/**
 * ClassName: AccountService
 * Package:com.ltx.bank.service
 * Description:
 *账户业务接口，负责处理业务
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/22 18:29
 */
public interface AccountService {
    /**
     * 完成账户转账业务
     * @param fromActno 转出账号
     * @param toActno 转入账号
     * @param money 转账金额
     */
    void transfer(String fromActno, String toActno, double money) throws MoneyNotEnoughException, TransferException;
}
