package com.ltx.oop02.thisProject.exer2;

/**
 * ClassName: BankTest
 * Package:com.ltx.oop02.thisProject.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/1 15:57
 */
public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("操","曹");
        bank.addCustomer("背","Liu");

        bank.getCustomer(0).setAccount(new Account(1000));

        bank.getCustomer(0).getAccount().withdraw(100);

        System.out.println(bank.getCustomer(0).getAccount().getBalance());
    }
}
