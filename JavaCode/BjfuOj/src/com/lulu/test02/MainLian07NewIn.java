package com.lulu.test02;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 定义一个包含图书信息（书号、书名、价格）的链表，读入相应的图书数据来完成图书信息表的创建，
 * 然后根据指定的待入库的新图书的位置和图书的信息，将新图书插入到图书表中指定的位置上，
 * 最后输出新图书入库后的所有图书的信息。
 *
 * 考察链表的插入，插入必须要知道前驱节点位置，它给我一个插入位置我可以使用循环让工作指针向后走
 * 几步，走到前驱位置。插入操作，先让待插入的节点的后继指向插入位置，再让前驱指向待插入节点。
 * 是否需要使用传统的方法进行链表的创建，还是沿用我们的想法，将next放在图书类中。发现不太行啊，
 * 如果不声明链表类的话，很多操作就很迷。
 */
public class MainLian07NewIn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Book07 head = null;
        Book07 trail = null;
        //进行链表创建
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            Book07 book = new Book07(id, name, price);
            if (head == null){
                head = book;
                trail = book;
            }else {
                trail.next = book;
                trail = book;
            }
        }
        //创建完成之后进行插入,我好像忘了链表的插入删除最好要设置一个虚拟头节点。虚拟头节点设置在你要完成的方法中
        int k = sc.nextInt();
        if (! (k > 0 && k <= n + 1)){
            System.out.println("Sorry，the position to be inserted is invalid!");
        }else {
            Book07 work = new Book07(null,null,0);
            work.next = head;
            for (int i = 0; i < k - 1; i++) {
                work = work.next;//走到插入位置之前的位置进行插入
            }
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            Book07 book07 = new Book07(id, name, price);
            //完成插入
            book07.next = work.next;
            work.next = book07;
            //最后输出信息
            Book07 cur = head;
            while (cur != null){
                System.out.printf("%s %s %.2f\n", cur.id,cur.name,cur.price);
                cur = cur.next;
            }
        }

    }
}
class Book07{
    public String id;
    public String name;
    public double price;
    public Book07 next;

    public Book07(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.next = null;
    }
}
