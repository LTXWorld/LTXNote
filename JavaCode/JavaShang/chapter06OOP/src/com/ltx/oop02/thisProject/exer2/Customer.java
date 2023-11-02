package com.ltx.oop02.thisProject.exer2;

/**
 * ClassName: Customer
 * Package:com.ltx.oop02.thisProject.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/1 15:47
 */
public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
