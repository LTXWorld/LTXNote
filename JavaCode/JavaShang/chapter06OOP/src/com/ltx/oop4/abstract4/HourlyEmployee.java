package com.ltx.oop4.abstract4;

/**
 * ClassName: HourlyEmployee
 * Package:com.ltx.oop4.abstract4
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 10:10
 */
public class HourlyEmployee extends Employee{
    private double wage;
    private int hour;

    public HourlyEmployee(String name, int number, MyDate birthday, double wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public HourlyEmployee() {
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public double earning() {
        return wage * hour;
    }
    public String toString(){
        return "HourlyEmployee[ " + super.toString() + "]";
    }
}
