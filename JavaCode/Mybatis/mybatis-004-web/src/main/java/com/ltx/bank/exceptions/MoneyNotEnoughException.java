package com.ltx.bank.exceptions;

/**
 * ClassName: MoneyNotEnoughException
 * Package:com.ltx.bank.exceptions
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/22 22:23
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException(){}
    public MoneyNotEnoughException(String msg){
        super(msg);
    }
}
