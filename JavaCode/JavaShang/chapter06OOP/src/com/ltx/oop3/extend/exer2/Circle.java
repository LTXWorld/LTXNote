package com.ltx.oop3.extend.exer2;

/**
 * ClassName: Circle
 * Package:com.ltx.oop3.extend.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/2 11:39
 */
public class Circle {
    private double radius;
    public Circle(){
        radius = 1;
    }
    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double findArea(){
        return Math.PI * radius * radius;
    }
}
