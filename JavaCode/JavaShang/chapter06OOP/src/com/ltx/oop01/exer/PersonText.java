package com.ltx.oop01.exer;



/**
 * ClassName: PersonText
 * Package:com.ltx.oop01.exer
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/27 16:28
 */
public class PersonText {
    public static void main(String[] args) {
        Person p1 = new Person();

        p1.age = 12;
        p1.name = "Tom";
        p1.gender = 'M';

        p1.study();
        int age = p1.showAge();
        System.out.println(age);

        p1.addAge(2);
        System.out.println(p1.showAge());

        Person p2 = new Person();

        System.out.println(p2.showAge());
        p2.addAge(10);
        System.out.println(p2.showAge());
    }
}
