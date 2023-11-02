package com.ltx.oop4.innerClass.exer2;

/**
 * ClassName: OuterClass2
 * Package:com.ltx.oop4.innerClass.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/8 10:25
 */
public class OuterClass2 {
    public static void main(String[] args) {
        //例子1
        new A(){
            public void method(){
                System.out.println("匿名实现类重写的方法");
            }
        }.method();

        new B(){
            @Override
            public void method1() {
                System.out.println("继承于抽象类的匿名子类的对象");
            }
        }.method1();

        System.out.println();

        //提供一个继承于c的匿名子类的对象
        C c = new C(){};//这个大括号挺离谱，直接在里面给c继承了一个子类
        System.out.println(c.getClass());
        System.out.println(c.getClass().getSuperclass());
    }
}
interface A{
    public void method();
}
class SubA implements A{
    @Override
    public void method() {
        System.out.println("suba");
    }
}

abstract class B{
    public abstract void method1();
}
class SubB extends B{
    @Override
    public void method1() {
        System.out.println("subb");
    }
}
class C{
    public void method2(){
        System.out.println("subc");
    }
}
