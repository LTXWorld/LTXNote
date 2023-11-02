package com.ltx.oop3.polymorphism.exer1;

/**
 * ClassName: Circle
 * Package:com.ltx.oop3.polymorphism.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/3 10:57
 */
public class Circle extends GeometricObject{
    private double radius;

    /**
     * 自动生成了父类中带参的构造器
     * @param color
     * @param weight
     * @param radius
     */
    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return Math.PI * radius * radius;
    }
}
