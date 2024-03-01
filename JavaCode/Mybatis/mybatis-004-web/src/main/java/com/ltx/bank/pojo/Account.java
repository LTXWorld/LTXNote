package com.ltx.bank.pojo;

/**
 * ClassName: Account
 * Package:com.ltx.bank.pojo
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/22 18:16
 */
public class Account {
    private Long id;
    private String actno;
    private Double balance;

    public Account(Long id, String actno, Double balance) {
        this.id = id;
        this.actno = actno;
        this.balance = balance;
    }

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
