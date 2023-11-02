package com.ltx.oop02.thisProject.exer;

/**
 * ClassName: BoyGirlTest
 * Package:com.ltx.oop02.thisProject.exer
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/1 15:32
 */
public class BoyGirlTest {
    public static void main(String[] args) {
        Boy boy1 = new Boy("杰克",22);
        Girl girl1 = new Girl("朱丽叶",24);

        girl1.marry(boy1);
        boy1.shout();

        Girl girl2 = new Girl("Rouse", 18);
        System.out.println(girl1.compare(girl2));
    }
}
