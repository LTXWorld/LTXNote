package com.ltx.oop3.toString.exer1;

/**
 * ClassName: GeometricObjecr
 * Package:com.ltx.oop3.toString.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/4 19:29
 */
public class GeometricObject {
    protected String color;
    protected double weight;
    protected GeometricObject(){
        color = "white";
        weight = 1.0;
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

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }
}
