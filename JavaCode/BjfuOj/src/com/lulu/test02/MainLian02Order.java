package com.lulu.test02;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 定义一个包含图书信息（书号、书名、价格）的链表，读入相应的图书数据完成图书信息表的创建，
 * 然后将图书按照价格降序排序，逐行输出排序后每本图书的信息。
 *
 * 读入信息放在一个链表里面，如何按照降序输出呢，在链表提供的输出方法中进行降序排列再输出？
 */
public class MainLian02Order {
    //本题解提供的方法很有意思，它没有去声明一些节点类或者链表类
    public static void main(String[] args) {
        //在主方法里面直接进行插入排序
        Scanner sc = new Scanner(System.in);
        BookOrder head = null;
        while (sc.hasNext()){
            String[] s = sc.nextLine().split(" ");
            String id = s[0];
            String name = s[1];
            double price = Double.parseDouble(s[2]);
            if(id.equals("0") && name.equals("0") && price == 0.0){
                break;
            }
            //接收完数据进行插入排序，在排序过程中此方法选择了循环遍历去排序
            BookOrder bookOrder = new BookOrder(id, name, price);
            if(head == null){
                head = bookOrder;
            }else{
                //head不为空时表示链表中是有节点的
                BookOrder pre = null;//插入节点需要知道其位置的前一个节点
                BookOrder cur = head;
                while (cur != null && cur.getPrice() > bookOrder.getPrice()){
                    //当你传进来的节点价格更低时，继续往后比较
                    pre = cur;
                    cur = cur.next;
                }
                //出这个while循环就两个可能，当前cur为null或者你传进来的价格更高
                if (pre == null){
                    head = bookOrder;
                }else{
                    //价格更高了，插入到两个中间了。
                    pre.next = bookOrder;
                }
                bookOrder.next = cur;//当前插入的图书与之前比较的链接起来。
            }
        }
        //进行输出
        BookOrder cur = head;
        while (cur != null){
            System.out.printf("%s %s %.2f\n",cur.getId(),cur.getName(),cur.getPrice());
            cur = cur.next;
        }
    }
}
class BookOrder{
    private String id;
    private String name;
    private double price;
    public BookOrder next;//可以这样声明next指针吗？

    public BookOrder(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.next = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

