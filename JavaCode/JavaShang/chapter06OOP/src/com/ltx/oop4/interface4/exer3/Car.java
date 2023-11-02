package com.ltx.oop4.interface4.exer3;

/**
 * ClassName: Car
 * Package:com.ltx.oop4.interface4.exer3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 14:12
 */
public class Car extends Vehicle implements IPower{
    private String carNumber;

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Car(String brand, String color, String carNumber) {
        super(brand, color);
        this.carNumber = carNumber;
    }

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public void run() {
        System.out.println("汽车通过内燃机驱动行驶");
    }

    @Override
    public void power() {
        System.out.println("汽车通过汽油提供动力");
    }
}
