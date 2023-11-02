package com.ltx.oop4.interface4.exer1;

/**
 * ClassName: Circle
 * Package:com.ltx.oop4.interface4.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 13:46
 */
public class Circle {
    private double radius;

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
