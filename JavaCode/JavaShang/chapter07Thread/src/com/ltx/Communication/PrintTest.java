package com.ltx.Communication;

/**
 * ClassName: PrintTest
 * Package:com.ltx.Communication
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/15 10:20
 */
class PrintNum implements Runnable{
    private int num = 1;
    @Override
    public void run() {


        while (true){
            synchronized (this){
                notify();//叫醒正处于wait的线程
                if (num <= 100){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + num);
                    num ++;
                    //进入等待阻塞状态，同时释放对同步监视器的调用;被叫醒后从wait后面开始执行
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    break;
                }
            }
        }
    }
}
public class PrintTest {
    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();
        Thread thread = new Thread(printNum, "线程一");
        Thread thread1 = new Thread(printNum, "线程二");

        thread.start();
        thread1.start();
    }
}
