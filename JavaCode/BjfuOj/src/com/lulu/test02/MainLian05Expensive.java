package com.lulu.test02;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 定义一个包含图书信息（书号、书名、价格）的链表，读入相应的图书数据来完成图书信息表的创建，
 * 然后查找价格最高的图书，输出相应图书的信息。
 * 总计输出m+1行，其中，第一行是最贵图书数目（价格最高的图书可能有多本），
 * 后m行是最贵图书的信息（书号、书名、价格），每本图书信息占一行，书号、书名、价格用空格分隔，
 * 其中价格输出保留两位小数。
 */
public class MainLian05Expensive {
    public static void main(String[] args) {
        //想法是这个最高价格在输入信息的时候我们就把它给比较得到。然后再去遍历链表遇到了就输出即可
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        double maxPrice = 0;
        BookNode05 head = null;
        BookNode05 trail = null;
        for (int i = 0; i < n; i++) {
            String[] info = sc.nextLine().split(" ");
            String id = info[0];
            String name = info[1];
            double price = Double.parseDouble(info[2]);
            BookNode05 bookNode05 = new BookNode05(id, name, price);
            //组成链表
            if(head == null){
                head = bookNode05;
                trail = bookNode05;
            }else{
                trail.next = bookNode05;
                trail = bookNode05;
            }
            //得到最贵图书价钱
            if(bookNode05.price > maxPrice){
                maxPrice = bookNode05.price;
            }
        }
        //但是这样写你会发现你写了两个几乎一样的while循环，一个为了找到数量，一个为了输出信息
        //有没有更好的方法呢？
        int nums = 0;
        BookNode05 cur = head;
        while (cur != null){
            if(cur.price == maxPrice){
                nums ++;
            }
            cur = cur.next;
        }
        System.out.println(nums);
        BookNode05 cur2 = head;
        while (cur2 != null){
            if(cur2.price == maxPrice){
                System.out.printf("%s %s %.2f\n",cur2.id,cur2.name,cur2.price);
            }
            cur2 = cur2.next;
        }
    }
}
class BookNode05{
    public String id;
    public String name;
    public double price;
    public BookNode05 next;

    public BookNode05(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.next = null;
    }
}
