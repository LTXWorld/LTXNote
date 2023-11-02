package com.ltx.oop4.innerClass.exer1;

/**
 * ClassName: ObjectTest
 * Package:com.ltx.oop4.innerClass.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/8 10:18
 */
public class ObjectTest {
    public static void main(String[] args) {
        SubObject sub1 = new SubObject();
        sub1.test();

        //提供匿名子类的匿名对象
         new Object(){
            public void test(){
                System.out.println("ssss");
            }
        }.test();//这里调用的是匿名内部类里面的ssss方法
    }
}
class SubObject extends Object{
    public void test(){
        System.out.println("sss");
    }
}