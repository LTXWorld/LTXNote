package com.ltx.oop4.interface4.exer3;

/**
 * ClassName: VehicleTest
 * Package:com.ltx.oop4.interface4.exer3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 14:16
 */
public class VehicleTest {
    public static void main(String[] args) {
        Developer developer = new Developer();
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Bicycle("捷安特","白色");
        vehicles[1] = new ElectricVehicle("雅迪","蓝色");
        vehicles[2] = new Car("奔驰","黑色","陕D1234");
        for (int i = 0; i < vehicles.length; i++) {
            developer.takingVehicle(vehicles[i]);
            if (vehicles[i] instanceof IPower){
                ((IPower) vehicles[i]).power();//强转的原因是此时的编译类型vehicle没有power方法
            }
        }
    }
}
