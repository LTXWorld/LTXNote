package com.ltx.oop4.abstract4;

/**
 * ClassName: Salary
 * Package:com.ltx.oop4.abstract4
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 10:03
 */
public class Salary extends Employee{
    private double monthly;

    public Salary(String name, int number, MyDate birthday, double monthly) {
        super(name, number, birthday);
        this.monthly = monthly;
    }

    public double getMonthly() {
        return monthly;
    }

    public void setMonthly(double monthly) {
        this.monthly = monthly;
    }


    @Override
    public double earning() {
        return monthly;
    }
    public String toString(){
        return "SalaryEmployee[ " + super.toString() + "]";
    }
}
