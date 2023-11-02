package com.ltx.oop3.polymorphism.exer1;

/**
 * ClassName: GeometricObjece
 * Package:com.ltx.oop3.polymorphism.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/3 10:52
 */
public class GeometricObject {
    protected String color;
    protected double weight;

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double findArea(){
        return 0.0;
    }
}
