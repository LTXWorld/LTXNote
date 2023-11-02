package com.ltx.oop4.interface4.exer3;

/**
 * ClassName: Vehicle
 * Package:com.ltx.oop4.interface4.exer3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 14:08
 */
public abstract class Vehicle {
    private String brand;
    private String color;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vehicle() {
    }

    public Vehicle(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }
    public abstract void run();
}
