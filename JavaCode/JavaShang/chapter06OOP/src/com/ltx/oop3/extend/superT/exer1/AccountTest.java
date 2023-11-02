package com.ltx.oop3.extend.superT.exer1;

/**
 * ClassName: AccountTest
 * Package:com.ltx.oop3.extend.superT.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/2 15:40
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct = new Account(112,20000,0.045);
        acct.withdraw(30000);

        System.out.println(acct.getBalance());

        acct.withdraw(2500);
        acct.deposit(3000);
        System.out.println(acct.getBalance());

        System.out.println(acct.getMonthlyInterest());
    }
}
