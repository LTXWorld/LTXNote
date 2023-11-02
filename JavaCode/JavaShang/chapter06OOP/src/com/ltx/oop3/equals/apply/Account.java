package com.ltx.oop3.equals.apply;

import java.util.Objects;

/**
 * ClassName: Account
 * Package:com.ltx.oop3.equals.apply
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/4 18:50
 */
public class Account {
    private double balance;
    public Account(){

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }
}
