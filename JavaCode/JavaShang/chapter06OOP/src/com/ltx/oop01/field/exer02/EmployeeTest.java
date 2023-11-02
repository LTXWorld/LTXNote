package com.ltx.oop01.field.exer02;

/**
 * ClassName: EmployeeTest
 * Package:com.ltx.oop01.field.exer02
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/26 15:21
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.id = 199;
        emp1.age = 20;
        emp1.name = "Tom";
        emp1.salary = 3275723.3423;
        emp1.birthday = new MyDate();
        emp1.birthday.year = 2001;
        emp1.birthday.day = 7;
        emp1.birthday.month = 5;
        System.out.println("Birthday = " + emp1.birthday.year);
    }
}
