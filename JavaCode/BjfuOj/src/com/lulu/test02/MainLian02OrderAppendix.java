package com.lulu.test02;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 上一个方法将next指针写入了book类当中，实际上你是没有显性地创建链表的。
 * 输入输出样例没有问题，但是最终显示答案错误，所以我猜测是因为没有声明链表类。
 * 这个方法我们来声明链表类，并且将插入排序方法放入链表类当中来。
 */
public class MainLian02OrderAppendix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookList2 bookList2 = new BookList2();
        while(sc.hasNext()){
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            if(id.equals("0") && name.equals("0") && price == 0.0){
                break;
            }
            BookOrder2 order2 = new BookOrder2(id, name, price);
            bookList2.add(order2);
        }
        bookList2.sort();
        bookList2.printInfo();
    }
}

class BookOrder2{
    private String id;
    private String name;
    private double price;
    public BookOrder2(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
class Node2{
    BookOrder2 data;
    Node2 next;
    //构造器设置注意
    public Node2(BookOrder2 data) {
        this.data = data;
        this.next = null;
    }

    public BookOrder2 getData() {
        return data;
    }

    public Node2 getNext() {
        return next;
    }

    public void setNext(Node2 next) {
        this.next = next;
    }
}
class BookList2{
    private Node2 head;

    public BookList2() {
        this.head = new Node2(null);
    }

    //尾插法进行插入
    public void add(BookOrder2 data){
        //插入时利用图书类对象新建一个节点类对象
        Node2 node2 = new Node2(data);
        Node2 p = head;
        if(p == null){
           p = node2;
        }
        while(p.getNext() != null){
            p = p.getNext();
        }
        p.setNext(node2);
    }
    //排序使用冒泡排序
    public void sort(){
        Node2 cur = head;
        while(cur != null){
            Node2 nextNode = cur.next;
            while (nextNode != null){
                if(cur.data.getPrice() < nextNode.data.getPrice()){
                    //如果下一个价格比你高，你就得让位。最终里面的while循环把最高价格放到了第一位
                    BookOrder2 temp = cur.data;
                    cur.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            //得到最高价格之后才把cur往后推一位
            cur = cur.next;
        }
    }
    //提供输出信息的方法
    public void printInfo(){
        Node2 p = head.getNext();
        while (p != null){
            BookOrder2 book = p.getData();
            System.out.printf("%s %s %.2f\n",book.getId(),book.getName(),book.getPrice());
            p = p.getNext();
        }
    }
}