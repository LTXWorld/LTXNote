package com.ltx.oop4.interface4.exer3;

/**
 * ClassName: Bicycle
 * Package:com.ltx.oop4.interface4.exer3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 14:09
 */
public class Bicycle extends Vehicle{
    public Bicycle(String brand, String color) {
        super(brand, color);
    }

    public Bicycle() {
    }

    @Override
    public void run() {
        System.out.println("自行车人力行驶");
    }
}
