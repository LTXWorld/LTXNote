package com.ltx.oop3.extend.exer1;

/**
 * ClassName: KidsTest
 * Package:com.ltx.oop3.extend.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/2 11:35
 */
public class KidsTest {
    public static void main(String[] args) {
        Kid1 kid1 = new Kid1();
        kid1.setSex(1);
        kid1.setSalary(100);
        kid1.setYearsOld(10);
        kid1.employeed();
        kid1.manOrWoman();
        kid1.printAge();
    }

}
