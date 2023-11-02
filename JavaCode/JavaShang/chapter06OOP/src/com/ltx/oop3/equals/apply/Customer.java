package com.ltx.oop3.equals.apply;

import java.util.Objects;

/**
 * ClassName: Customer
 * Package:com.ltx.oop3.equals.apply
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/4 18:51
 */
public class Customer {
    private String name;
    private int age;
    private Account account;
    public Customer(){

    }

    public Customer(String name, int age, Account account) {
        this.name = name;
        this.age = age;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return age == customer.age && Objects.equals(name, customer.name) && Objects.equals(account, customer.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, account);
    }
}
