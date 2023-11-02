package com.ltx.oop3.extend.exer2;

/**
 * ClassName: CylinderTest
 * Package:com.ltx.oop3.extend.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/2 11:43
 */
public class CylinderTest {
    public static void main(String[] args) {
        Cylinder c = new Cylinder();
        c.setLength(2);
        c.setRadius(3);

        System.out.println(c.findVolume());
    }
}
