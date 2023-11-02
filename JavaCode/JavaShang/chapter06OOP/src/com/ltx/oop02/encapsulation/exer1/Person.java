package com.ltx.oop02.encapsulation.exer1;

/**
 * ClassName: Person
 * Package:com.ltx.oop02.encapsulation.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/30 15:59
 */
public class Person {
    private int age;

    public void setAge(int a){
        if(a >= 0 && a <= 130){
            age = a;
        }else{
            System.out.println("输入值非法");
        }
    }

    public int getAge(){
        return age;
    }
}
