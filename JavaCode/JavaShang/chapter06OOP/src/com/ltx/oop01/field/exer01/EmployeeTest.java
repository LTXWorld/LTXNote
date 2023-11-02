package com.ltx.oop01.field.exer01;

/**
 * ClassName: EmployeeTest
 * Package:com.ltx.oop01.field.exer01
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/26 15:07
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        System.out.println(employee);
        employee.age = 25;
        employee.id = 1002;
        employee.salary = 34957.513;
        employee.name = " llll";
        System.out.println("id = " + employee.id + " age = " + employee.age + " salary = " + employee.salary + "name = " + employee.name);
    }
}
