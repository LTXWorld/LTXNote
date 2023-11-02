package com.ltx.oop3.polymorphism.exer2;

/**
 * ClassName: Dog
 * Package:com.ltx.oop3.polymorphism.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/3 11:18
 */
public class Dog extends Animal{
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dog(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }
    public void watchDoor(){
        System.out.println("看门");
    }

    @Override
    public void eat() {
        System.out.println("狗吃屎");
    }

    @Override
    public void jump() {
        watchDoor();
    }
}
