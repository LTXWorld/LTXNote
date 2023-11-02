package com.ltx.oop3.polymorphism.exer3;

/**
 * ClassName: Man
 * Package:com.ltx.oop3.polymorphism.exer3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/3 12:38
 */
public class Man extends Person{
    @Override
    public void eat() {
        System.out.println("男人大口吃");
    }

    @Override
    public void toilet() {
        System.out.println("男人去男厕所");
    }

    public void smoke(){
        System.out.println("抽烟");
    }
}
