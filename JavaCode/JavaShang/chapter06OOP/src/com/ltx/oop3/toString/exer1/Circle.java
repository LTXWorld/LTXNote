package com.ltx.oop3.toString.exer1;

/**
 * ClassName: Circle
 * Package:com.ltx.oop3.toString.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/4 19:31
 */
public class Circle extends GeometricObject{
    private double radius;

    public Circle() {
        color = "white";
        weight = 1.0;
        radius = 1.0;
    }

    public Circle(double radius) {
        color = "white";
        weight = 1.0;
        //这里其实不需要写前两句，因为会自动调用super（）父类里的构造器,父类里面已经初始化过了
        this.radius = radius;
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);//调用父类里的构造器
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Circle){
            Circle c = (Circle) obj;
            return this.radius == c.radius;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CircleRadius = " + radius + ")";
    }
}
