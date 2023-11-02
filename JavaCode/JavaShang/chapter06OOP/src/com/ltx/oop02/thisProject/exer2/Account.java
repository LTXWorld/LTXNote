package com.ltx.oop02.thisProject.exer2;

/**
 * ClassName: Account
 * Package:com.ltx.oop02.thisProject.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/1 15:37
 */
public class Account {
    private double balance;

    public Account(double init_balance) {
        this.balance = init_balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt){
        if(amt > 0){
            balance += amt;
            System.out.println("存入" + amt);
        }else{
            System.out.println("error");
        }
    }

    public void withdraw(double amt){
        if(balance >= amt && amt > 0){
            balance -= amt;
            System.out.println("取出" + amt);
        }else {
            System.out.println("error");
        }
    }
}
