package com.ltx.ThreadR.exer1;

/**
 * ClassName: WindowTest
 * Package:com.ltx.ThreadR.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/14 20:24
 */
class SaleTicket implements Runnable{
    int ticketNum = 100;//被多个线程所共享
    //Object obj = new Object();
    @Override
    public void run() {
        while (true){
            synchronized (this){
                if (ticketNum > 0){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "票号为 " + ticketNum);
                    ticketNum --;
                }else {
                    break;
                }
            }
        }
    }
}
public class WindowTest {
    public static void main(String[] args) {
        SaleTicket saleTicket = new SaleTicket();
        Thread thread = new Thread(saleTicket);
        Thread thread1 = new Thread(saleTicket);
        Thread thread2 = new Thread(saleTicket);

        thread.setName("1");
        thread1.setName("2");
        thread2.setName("3");

        thread.start();
        thread1.start();
        thread2.start();
    }
}
