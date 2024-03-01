package com.ltx.bank.exceptions;

/**
 * ClassName: TransferException
 * Package:com.ltx.bank.exceptions
 * Description:
 *转账异常
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/22 22:29
 */
public class TransferException extends Exception{
    public TransferException(String message) {
        super(message);
    }

    public TransferException() {
    }
}
