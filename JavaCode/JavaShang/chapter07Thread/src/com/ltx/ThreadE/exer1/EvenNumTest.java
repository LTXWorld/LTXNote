package com.ltx.ThreadE.exer1;

/**
 * ClassName: EvenNumTest
 * Package:com.ltx.ThreadE.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/13 18:30
 */
public class EvenNumTest {
    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        printNum.start();
        OddPrint oddPrint = new OddPrint();
        oddPrint.start();
        //匿名内部类，直接在里面重写run方法
        new Thread(){
            public void run() {
                for (int i = 1; i < 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ":" + i);
                    }
                }
            }
        }.start();
    }
}
class PrintNum extends Thread{
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
class OddPrint extends Thread{
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
