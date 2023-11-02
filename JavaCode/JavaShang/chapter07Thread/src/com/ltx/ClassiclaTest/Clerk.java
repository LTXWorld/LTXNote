package com.ltx.ClassiclaTest;

/**
 * ClassName: Clerk
 * Package:com.ltx.ClassiclaTest
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/15 10:46
 */
public class Clerk {
    private int producerNum = 0;

    public int getProducerNum() {
        return producerNum;
    }

    public void setProducerNum(int producerNum) {
        this.producerNum = producerNum;
    }
    //增加减少产品数量的方法
    public synchronized void addP(){
        if (producerNum >= 20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        producerNum ++;
        System.out.println(Thread.currentThread().getName() + "生产了" + producerNum + "个产品");
        //只要生产了一个就得去唤醒消费者
        notify();
    }
    public synchronized void minusP(){
        if (producerNum <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "消费了" + producerNum + "个产品");
        producerNum --;
        notify();
    }
}
