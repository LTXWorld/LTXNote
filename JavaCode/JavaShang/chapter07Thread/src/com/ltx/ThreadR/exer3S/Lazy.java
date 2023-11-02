package com.ltx.ThreadR.exer3S;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ClassName: Lazy
 * Package:com.ltx.ThreadR.exer3S
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/15 09:12
 */
public class Lazy {
    static Bank b1 = null;
    static Bank b2 = null;

    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                 b1 = Bank.getInstance();
            }
        };
        Thread thread2 = new Thread(){
            @Override
            public void run() {
                b2 = Bank.getInstance();
            }
        };

        thread1.start();
        thread2.start();

        System.out.println(b1);
        System.out.println(b2);
    }
}
class Bank{
    private static final ReentrantLock lock = new ReentrantLock();
    private Bank (){

    }

    private static volatile Bank instance = null;

    public  static Bank getInstance() {
        lock.lock();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (instance == null){
            instance = new Bank();
        }
        lock.unlock();
        return instance;

    }
}