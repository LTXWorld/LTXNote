package com.ltx.ClassiclaTest;

/**
 * ClassName: Consumer
 * Package:com.ltx.ClassiclaTest
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/15 10:46
 */
public class Consumer extends Thread{
    private Clerk clerk;
    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }
    public void run() {
        while (true){
            System.out.println("消费者开始消费产品");
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.minusP();
        }
    }
}
