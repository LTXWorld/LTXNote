package com.ltx.oop3.polymorphism.exer2;

/**
 * ClassName: Animal
 * Package:com.ltx.oop3.polymorphism.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/3 11:15
 */
public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("吃东西");
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

    public void jump(){
        System.out.println("跳起来");
    }
}
