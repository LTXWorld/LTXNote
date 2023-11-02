package com.ltx.oop3.equals.apply;

/**
 * ClassName: CustomerTest
 * Package:com.ltx.oop3.equals.apply
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/4 18:53
 */
public class CustomerTest {
    public static void main(String[] args) {
        Customer c1 = new Customer("Tom",12,new Account(2000));
        Customer c2 = new Customer("Tom",12,new Account(2000));

        System.out.println(c1.equals(c2));
        //即使自动重写了，但是比较时有属性为引用类型就会需要再次加一个重写

    }
}
