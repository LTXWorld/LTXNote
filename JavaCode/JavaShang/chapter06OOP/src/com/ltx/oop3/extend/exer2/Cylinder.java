package com.ltx.oop3.extend.exer2;

/**
 * ClassName: Cylinder
 * Package:com.ltx.oop3.extend.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/2 11:39
 */
public class Cylinder extends Circle{
    private double length;
    public Cylinder(){
        length = 1;
    }

    public Cylinder(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double findArea() {
        return super.findArea();
    }

    public double findVolume(){
        return Math.PI * getRadius() * getRadius() * getLength();
    }
}
