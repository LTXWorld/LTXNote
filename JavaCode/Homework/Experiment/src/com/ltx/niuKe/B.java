package com.ltx.niuKe;

import java.util.Map;

/**
 * ClassName: Test01
 * Package:com.ltx.niuKe
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/15 19:37
 */
public class B extends A{
    public B(){
        System.out.println("class B");
    }
    {
        System.out.println("I am B class");
    }
    static {
        System.out.println("class B static");
    }

    public static void main(String[] args) {
        new B();
    }
}
class A{
    public A(){
        System.out.println("class A");
    }
    {
        System.out.println("I am A class");
    }
    static {
        System.out.println("class A static");
    }
}

