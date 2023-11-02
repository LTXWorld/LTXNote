package com.ltx.ThreadR.exer2;

/**
 * ClassName: WindowTest2
 * Package:com.ltx.ThreadR.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/14 21:14
 */
class SaleTicket1 implements Runnable {
    int ticketNum = 100;//被多个线程所共享

    //Object obj = new Object();
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (ticketNum > 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "票号为 " + ticketNum);
                    ticketNum--;
                } else {
                    break;
                }
            }
        }
    }
}

public class WindowTest2 {
    public static void main(String[] args) {
        SaleTicket1 saleTicket1 = new SaleTicket1();
        Thread thread0 =  new Thread(saleTicket1);
        Thread thread1 = new Thread(saleTicket1);
        Thread thread2 = new Thread(saleTicket1);

        thread0.setName("1");
        thread1.setName("2");
        thread2.setName("3");

        thread0.start();
        thread1.start();
        thread2.start();
    }
}

