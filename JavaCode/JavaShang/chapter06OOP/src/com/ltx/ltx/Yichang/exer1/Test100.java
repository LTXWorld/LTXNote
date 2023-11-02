package com.ltx.ltx.Yichang.exer1;

/**
 * ClassName: Test100
 * Package:com.ltx.Yichang.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 10:08
 */
public class Test100 {
    public static void main(String[] args) {
//        Person p1 = new Person("LLL", 10);
//        System.out.println(p1);
        try {
            Person p2 = new Person("TTT", -10);
            System.out.println(p2);
        }catch (NoLifeValueException e){
            System.out.println(e.getMessage());
        }
        //空参
        Person p3 = new Person();
        p3.setName("jerry");
        p3.setLifeValue(-1);
    }
}
