package com.lulu.test02;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 */
public class MainLian07NewInAppendix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        //新建链表
        ListNode7 listNode7 = new ListNode7();
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            Book07a book = new Book07a(id, name, price);
            listNode7.add(book);
        }
        int insertIndex = sc.nextInt();
        sc.nextLine();
        String id = sc.next();
        String name = sc.next();
        double price = sc.nextDouble();
        Book07a book = new Book07a(id, name, price);
        if(listNode7.insert(insertIndex - 1,book)){
            //如果为真表示插入位置合法并且已经插入了
            listNode7.printInfo();
        }else {
            System.out.println("Sorry，the position to be inserted is invalid!");
        }
    }
}
class Book07a{
    public String id;
    public String name;
    public double price;

    public Book07a(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
//其实兜兜转转为了更好得分，还是需要声明三个类来写这个程序
class Node7{
    Book07a data;
    Node7 next;

    public Node7(Book07a data) {
        this.data = data;
        this.next = null;
    }

    public Book07a getData() {
        return data;
    }

    public Node7 getNext() {
        return next;
    }

    public void setNext(Node7 next) {
        this.next = next;
    }
}
class ListNode7{
    private Node7 dummyHead;//设置虚拟头节点
    private int size;

    public ListNode7() {
        dummyHead = new Node7(null);
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void add(Book07a book07a){
        Node7 newNode = new Node7(book07a);
        Node7 cur = dummyHead;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        size ++;
    }
    //插入方法需要知道插入位置从0-长度，以及插入的对象
    public boolean insert(int index,Book07a book){
        if(index < 0 || index > size){
            return false;
        }
        Node7 pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node7 InsetNode = new Node7(book);//创建一个新结点待插入节点
        InsetNode.next = pre.next;
        pre.next = InsetNode;
        size ++;
        return true;
    }
    public void printInfo(){
        Node7 p =dummyHead.next;
        while (p != null){
            Book07a book = p.getData();
            System.out.printf("%s %s %.2f\n",book.id,book.name,book.price);
            p = p.getNext();
        }
    }
}
