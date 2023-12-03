package com.lulu.test02;

import java.util.*;

/**
 * @author LTX
 * @version 01
 * 这个版本他妈的使用到了LinkedList集合这玩意底层是双向链表，通过这个东西来写的链表，居然通过了。
 */
public class MainLian02OrderAppendix2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BookAppendix> books = new LinkedList<>();//这里使用了LinkedList过了

        //读入数据
        while(true){
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            if(id.equals("0") && name.equals("0") && price == 0.0){
                break;
            }
            BookAppendix bookAppendix = new BookAppendix(id,name,price);
            books.add(bookAppendix);
        }

        //使用集合自带的排序方法对链表进行排序
        Collections.sort(books, new Comparator<BookAppendix>() {
            @Override
            public int compare(BookAppendix o1, BookAppendix o2) {
                if(o1.price < o2.price){
                    return 1;//如果价格低就把它放到2的后面去
                }else if(o1.price > o2.price){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        for(BookAppendix bookAppendix : books){
            System.out.printf("%s %s %.2f\n",bookAppendix.id,bookAppendix.name,bookAppendix.price);
        }
    }
}
class BookAppendix{
    public String id;
    public String name;
    public double price;

    public BookAppendix(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

