package com.ltx.oop4.interface4.exer3;

/**
 * ClassName: Developer
 * Package:com.ltx.oop4.interface4.exer3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 14:05
 */
public class Developer {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Developer() {
    }

    public Developer(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void takingVehicle(Vehicle vehicle){
        vehicle.run();
    }
}
