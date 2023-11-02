package com.ltx.oop4.interface4.exer3;

/**
 * ClassName: ElectricVehicle
 * Package:com.ltx.oop4.interface4.exer3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 14:10
 */
public class ElectricVehicle extends Vehicle implements IPower{
    public ElectricVehicle(String brand, String color) {
        super(brand, color);
    }

    public ElectricVehicle() {
    }

    @Override
    public void run() {
        System.out.println("电动车通过电机行驶");
    }

    @Override
    public void power() {
        System.out.println("电动车使用电力实现动力");
    }
}
