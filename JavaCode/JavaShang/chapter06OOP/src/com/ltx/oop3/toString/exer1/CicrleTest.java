package com.ltx.oop3.toString.exer1;

/**
 * ClassName: CicrleTest
 * Package:com.ltx.oop3.toString.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/4 19:36
 */
public class CicrleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle("Red",1.0,2.0);
        System.out.println("颜色是否相等" + c1.getColor().equals(c2.getColor()));
        System.out.println("半径是否相等" + c1.equals(c2));
        System.out.println(c1);//由于print这个底层也调的toString，所以这里输出还是重写的toString
        System.out.println(c2.toString());
    }
}
