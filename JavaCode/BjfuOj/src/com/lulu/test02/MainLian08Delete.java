package com.lulu.test02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 定义一个包含图书信息（书号、书名、价格）的链表，读入相应的图书数据来完成图书信息表的创建，
 * 然后根据指定的待出库的旧图书的位置，将该图书从图书表中删除，最后输出该图书出库后的所有图书的信息。
 * 思路差不多，先建链表，然后再找到指定位置去删除，但是删除的时候定位要在删除位置前一个地方
 * 依然要设置虚拟头节点
 */
public class MainLian08Delete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ListNode8 listNode8 = new ListNode8();
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            Book8 book = new Book8(id, name, price);
            listNode8.add(book);
        }
        //
        int index = sc.nextInt();
        if (listNode8.delete(index - 1)){
            listNode8.printInfo();
        }else {
            System.out.println("Sorry，the position to be deleted is invalid!");
        }
    }
}
class Book8{
    public String id;
    public String name;
    public double price;

    public Book8(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
class Node8{
    Book8 data;
    Node8 next;

    public Node8(Book8 data) {
        this.data = data;
        this.next = null;
    }

    public void setData(Book8 data) {
        this.data = data;
    }

    public void setNext(Node8 next) {
        this.next = next;
    }

    public Node8 getNext() {
        return next;
    }
}
class ListNode8{
    private Node8 dummyHead;
    private int size;

    public int getSize() {
        return size;
    }

    public ListNode8() {
        this.dummyHead = new Node8(null);
        this.size = 0;
    }
    //提供删除方法
    public  boolean delete(int index){
        if(index < 0 || index >= size){
            return false;
        }
        Node8 pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;//走到删除位置前驱
        }
        pre.next = pre.next.next;
        size --;
        return true;
    }
    //提供尾插法
    public void add(Book8 book8){
        Node8 node8 = new Node8(book8);
        Node8 p = dummyHead;
        while (p.next != null){
            p = p.next;
        }
        p.setNext(node8);
        size ++;
    }
    public void printInfo(){
        Node8 p =dummyHead.next;
        while (p != null){
            Book8 book = p.data;
            System.out.printf("%s %s %.2f\n",book.id,book.name,book.price);
            p = p.getNext();
        }
    }
}


