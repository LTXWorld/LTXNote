package com.ltx.oop4.SpecialEnum.exer2;

/**
 * ClassName: BankTest
 * Package:com.ltx.oop4.SpecialEnum.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/8 11:52
 */
public class BankTest {
}
class Bank1{
    //构造器私有化
    private Bank1(){

    }
    //直接在类中创建对象了
//    private static Bank1 instance = new Bank1();
//
//    public static Bank1 getInstance(){
//        return instance;
//    }
    public static final Bank1 instance = new Bank1();
    //记得加入final防止更改对象
}
enum Bank2{
    CPB;
}
