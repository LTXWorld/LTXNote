package com.ltx.oop4.abstract4;

/**
 * ClassName: PayrollSystem
 * Package:com.ltx.oop4.abstract4
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 10:13
 */
public class PayrollSystem {
    public static void main(String[] args) {
        Employee[] emps = new Employee[2];
        emps[0] = new Salary("zz",1001,new MyDate(1992,12,21),18000);
        emps[1] = new HourlyEmployee("ss",1002,new MyDate(2001,5,7),200,9);
        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i].toString());
            System.out.println("工资为" + emps[i].earning());
        }
    }
}
