package com.ltx.oop4.interface4.exer2;

/**
 * ClassName: EatableTest
 * Package:com.ltx.oop4.interface4
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 13:42
 */
public class EatableTest {
    public static void main(String[] args) {
        Eatable[] eatables = new Eatable[3];
        eatables[0] = new Chinese();
        eatables[1] = new American();
        eatables[2] = new Indian();
        for (int i = 0; i < eatables.length; i++) {
            eatables[i].eat();
        }
    }
}
