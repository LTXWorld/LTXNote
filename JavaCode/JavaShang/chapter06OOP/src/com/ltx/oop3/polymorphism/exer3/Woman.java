package com.ltx.oop3.polymorphism.exer3;

/**
 * ClassName: Woman
 * Package:com.ltx.oop3.polymorphism.exer3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/3 12:41
 */
public class Woman extends Person{
    @Override
    public void eat() {
        System.out.println("女人慢点吃");
    }

    @Override
    public void toilet() {
        System.out.println("女人上厕所");
    }
    public void Face(){
        System.out.println("补妆");
    }
}
