package com.ltx.oop3.extend.superT.exer1;

/**
 * ClassName: CheckAccount
 * Package:com.ltx.oop3.extend.superT.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/2 15:45
 */
public class CheckAccount extends Account{
    private double overdraft;//可透支额度
    /**
     * 调用父类的构造器，整个作为子类自己的构造器
     * @param id
     * @param balance
     * @param annualInterestRate
     */
    public CheckAccount(int id,double balance,double annualInterestRate,double overdraft){
        super(id,balance,annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    /**
     * 针对于可透支账户取钱操作，重写父类的
     * @param amount
     */
    public void withdraw(double amount){
        if(getBalance() >= amount){
            super.withdraw(amount);
        }else if(getBalance() + overdraft >= amount){
            overdraft -=  amount - getBalance();//这两句容易弄反，导致余额为0
            super.withdraw(getBalance());
        }else{
            System.out.println("超过可透支限额");
        }
    }
}
