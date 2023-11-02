package com.ltx.oop02.encapsulation.exer1;

/**
 * ClassName: PersonTest
 * Package:com.ltx.oop02.encapsulation.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/30 16:02
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(22);
        System.out.println(p1.getAge());
    }
}
