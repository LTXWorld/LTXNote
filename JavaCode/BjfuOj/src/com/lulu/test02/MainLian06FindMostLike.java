package com.lulu.test02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 */
public class MainLian06FindMostLike {
    public static void main(String[] args) {
        /**
         * 根据顺序表的写法，对于输入的图书名称进行接收，并编写一个找到最喜欢图书将其放入数组当中
         * 的方法，最后通过遍历这个新的数组进行输出。这样做可行吗？
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        double maxPrice = 0;
        BookNode06 head = null;
        BookNode06 trail = null;
        for (int i = 0; i < n; i++) {
            String[] info = sc.nextLine().split(" ");
            String id = info[0];
            String name = info[1];
            double price = Double.parseDouble(info[2]);
            BookNode06 bookNode06 = new BookNode06(id, name, price);
            //组成链表
            if (head == null) {
                head = bookNode06;
                trail = bookNode06;
            } else {
                trail.next = bookNode06;
                trail = bookNode06;
            }
        }
        int m = sc.nextInt();
        sc.nextLine();
        //遍历寻找最爱图书，调用searchLike方法
        for (int i = 0; i < m; i++) {
            String LikeName = sc.nextLine();//得到你输入的最爱图书
            List<BookNode06> bookNode06s = searchLike(head, LikeName);
            if(bookNode06s.size() > 0){//证明里面有你要的图书
                System.out.println(bookNode06s.size());//先输出喜欢图书的数量
                for(BookNode06 bookNode06 : bookNode06s){
                    System.out.printf("%s %s %.2f\n",bookNode06.id,bookNode06.name,bookNode06.price);
                }
            }else {
                System.out.println("Sorry，there is no your favourite!");
            }
        }
    }
    //编写一个寻找最爱图书的方法，使用遍历的思想，没有采取简便的哈希,返回的是一个集合。
    public static List<BookNode06> searchLike(BookNode06 head,String name){
        List<BookNode06> result = new ArrayList<>();
        BookNode06 cur = head;
        while(cur != null){
            if(cur.name.equals(name)){
                result.add(cur);
            }
            cur = cur.next;
        }
        return result;
    }
}
class BookNode06{
    public String id;
    public String name;
    public double price;
    public BookNode06 next;

    public BookNode06(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.next = null;
    }
}
