package com.ltx.oop01.ValueTransfer;

/**
 * ClassName: Trans
 * Package:com.ltx.oop01.ValueTransfer
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/28 14:24
 */
public class Trans {
    public static void main(String[] args) {
        Trans trans = new Trans();
        int m = 10;
        trans.method1(m);
        System.out.println(m);//这三个m是main方法里的m

        Person p1 = new Person();
        p1.age = 10;
        trans.method2(p1);
        System.out.println(p1.age);
    }
    public void method1(int m){//这两个m是method方法里的m
        m ++;
    }
    public void method2(Person p){
        p.age ++;
    }
}
class Person{
    int age;
}

