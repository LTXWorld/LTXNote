package com.ltx.ClassiclaTest;

/**
 * ClassName: Producer
 * Package:com.ltx.ClassiclaTest
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/15 10:42
 */
public class Producer extends Thread{
    private Clerk clerk;
    public Producer(Clerk clerk){
        this.clerk = clerk;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("生产者开始生产产品");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addP();
        }
    }
}
