package com.ltx.oop3.polymorphism.exer1;

/**
 * ClassName: MyRectangle
 * Package:com.ltx.oop3.polymorphism.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/3 11:01
 */
public class MyRectangle extends GeometricObject{
    private double width;
    private double high;

    public MyRectangle(String color, double weight, double width, double high) {
        super(color, weight);
        this.width = width;
        this.high = high;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    @Override
    public double findArea() {
        return width * high;
    }
}
