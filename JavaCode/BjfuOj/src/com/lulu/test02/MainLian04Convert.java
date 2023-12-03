package com.lulu.test02;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 定义一个包含图书信息（书号、书名、价格）的链表，读入相应的图书数据来完成图书信息表的创建，
 * 然后将读入的图书逆序存储，逐行输出逆序存储后每本图书的信息。
 */
public class MainLian04Convert {
    public static void main(String[] args) {
        //要求逆序存储，存的时候就得逆序。头插法实现逆序，但我想的头插法好像没这么复杂。
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        BookNode04 head = null;
        BookNode04 trail = null;//尾指针都没用到
        for (int i = 0; i < n; i++) {
            String[] info = sc.nextLine().split(" ");
            String id = info[0];
            String name = info[1];
            double price = Double.parseDouble(info[2]);
            BookNode04 bookNode04 = new BookNode04(id, name, price);
            //逆序地构建链表
            if(head == null){
                head = bookNode04;
            }else{
                //进行头插
                bookNode04.next = head;
                head = bookNode04;
            }
        }
        //进行输出
        BookNode04 cur = head;
        while (cur != null){
            System.out.printf("%s %s %.2f\n",cur.id,cur.name,cur.price);
            cur = cur.next;
        }
    }
}
class BookNode04{
    public String id;
    public String name;
    public double price;
    public BookNode04 next;

    public BookNode04(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.next = null;
    }
}
