package com.lulu.test02;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 出版社出版的任何一本图书的书号（ISBN）都是唯一的，即图书表中不允许包含书号重复的图书。
 * 定义一个包含图书信息（书号、书名、价格）的链表，读入相应的图书数据来完成图书信息表的创建
 * （书号可能重复），然后进行图书的去重，即删除书号重复的图书（只保留第一本）
 * 最后输出去重后所有图书的信息。
 *
 * 看到输入输出模式肯定要设置size最后来输出；最暴力的方法使用双层for循环，但是就算找到后面书号相同
 * 链表的删除很复杂，我需要找到要删除位置的前一个位置来完成删除。
 * 发现这道题和力扣题目非常像啊，力扣只是完成了其中一部分，我每遇到一个书号进行一次这样的操作不就行了
 */
public class MainLian09Repeat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ListBook9 listBook9 = new ListBook9();

        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            Book9 book9 = new Book9(id, name, price);
            listBook9.add(book9);
        }
        //去重
        Node9 p = listBook9.head;
        while (p != null){
            listBook9.removeRepeat(listBook9.head, p.data.id);
            p = p.next;
        }
        listBook9.printInfo();
    }
}
class Book9{
    public String id;
    public String name;
    public double price;

    public Book9(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
class Node9{
    Book9 data;
    Node9 next;

    public Node9(Book9 data) {
        this.data = data;
        this.next = null;
    }

    public void setData(Book9 data) {
        this.data = data;
    }

    public void setNext(Node9 next) {
        this.next = next;
    }
}
class ListBook9{
    Node9 head;
    public int size;
    //初始化链表
    public ListBook9() {
        this.head = new Node9(null);
        this.size = 0;
    }
    //尾插法创建链表，这里的head作为我的首节点，虚拟头节点的后一个节点
    public void add(Book9 data){
        Node9 node9 = new Node9(data);
        if(head == null){
            head = node9;
        }
        Node9 p = head;
        while (p.next != null){
            p = p.next;
        }
        p.setNext(node9);
        size ++;
    }

    /**
     *
     * @param head 传入链表的头节点相当于整个链表，我要对他进行操作
     * @param id    传入你每次想要去重的id。
     * @return  返回的是头节点？那到时候怎么输出呢？
     */
    public Node9 removeRepeat(Node9 head,String id){
        if(head == null){
            return head;
        }
        Node9 dummyHead = new Node9(null);
        dummyHead.next = head;//让虚拟头节点指向首节点
        Node9 pre = dummyHead;
        Node9 cur = head;
        while (cur != null){
            if(cur.data.id.equals(id)){
                pre.next = cur.next;
                size --;
            }else{
                pre = pre.next;//pre保持在cur前面一个位置
            }
            cur = cur.next;//无论删不删cur都要往后走。
        }
        return dummyHead.next;
    }
    //提供输出信息的方法
    public void printInfo(){
        Node9 p = head;
        while (p != null){
            Book9 book9 = p.data;
            System.out.printf("%s %s %.2f\n",book9.id,book9.name,book9.price);
            p = p.next;
        }
    }
}