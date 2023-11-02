package com.ltx.oop4.interface4.exer1;

/**
 * ClassName: InterfaceTest
 * Package:com.ltx.oop4.interface4.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 13:54
 */
public class InterfaceTest {
    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(2.3);
        ComparableCircle c2 = new ComparableCircle(5.3);

        int value = c1.compareTo(c2);
        if (value > 0){
            System.out.println("1大");
        }else if (value < 0){
            System.out.println("2大");
        }else{
            System.out.println("一样大");
        }
    }
}
