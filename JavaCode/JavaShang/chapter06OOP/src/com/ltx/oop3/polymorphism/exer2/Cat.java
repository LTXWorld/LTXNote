package com.ltx.oop3.polymorphism.exer2;

/**
 * ClassName: Cat
 * Package:com.ltx.oop3.polymorphism.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/3 11:18
 */
public class Cat extends Animal{
    private int id;

    public Cat(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void Fish(){
        System.out.println("Eat Fish");
    }

    @Override
    public void eat() {
        System.out.println("猫猫吃鱼");
    }
}
