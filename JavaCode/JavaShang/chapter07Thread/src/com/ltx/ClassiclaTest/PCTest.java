package com.ltx.ClassiclaTest;

/**
 * ClassName: PCTest
 * Package:com.ltx.ClassiclaTest
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/15 10:42
 */
public class PCTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer pr1 = new Producer(clerk);
        Consumer co1 = new Consumer(clerk);
        pr1.setName("生产者1");
        co1.setName("消费者1");
    }
}
