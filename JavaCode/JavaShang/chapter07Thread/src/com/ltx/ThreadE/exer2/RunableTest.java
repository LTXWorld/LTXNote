package com.ltx.ThreadE.exer2;

/**
 * ClassName: RunableTest
 * Package:com.ltx.ThreadE.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/14 17:30
 */
public class RunableTest {
    public static void main(String[] args) {
        OddNum oddNum = new OddNum();
        Thread thread = new Thread(oddNum);
        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("000000");
            }
        }).start();
    }
}
class OddNum implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}
