package com.ltx.oop01.exer;

/**
 * ClassName: Person
 * Package:com.ltx.oop01.exer
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/27 16:25
 */
public class Person {
    int age;
    String name;
    char gender;

    public void study(){
        System.out.println("Studying");
    }
    public int showAge(){
        return age;
    }
    public void addAge(int addAge){
        age += addAge;
    }
}
