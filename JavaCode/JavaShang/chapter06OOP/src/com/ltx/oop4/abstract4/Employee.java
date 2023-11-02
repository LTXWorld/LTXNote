package com.ltx.oop4.abstract4;

/**
 * ClassName: Employee
 * Package:com.ltx.oop4.abstract4
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 09:57
 */
public abstract class Employee {
    private String name;
    private int number;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }
    public abstract double earning();
    public String toString(){
        return "name = " + name + "number= " + number + " , birthday= " + birthday.toDateString();
    }
}
