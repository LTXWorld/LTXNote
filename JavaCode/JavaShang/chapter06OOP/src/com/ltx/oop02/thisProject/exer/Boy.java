package com.ltx.oop02.thisProject.exer;

/**
 * ClassName: Boy
 * Package:com.ltx.oop02.thisProject.exer
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/1 15:15
 */
public class Boy {
    private String name;
    private int age;

    public Boy(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void marry(Girl girl){
        System.out.println("Marry with" + girl.getName());
    }

    public void shout(){
        if(this.age >= 22){
            System.out.println("Marry");
        }else {
            System.out.println("No");
        }
    }
}
