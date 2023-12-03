package com.lulu.test02;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 定义一个包含图书信息（书号、书名、价格）的链表，读入相应的图书数据来完成图书信息表的创建，
 * 然后统计图书表中的图书个数，同时逐行输出每本图书的信息。
 * 输入n+1行，其中前n行是n本图书的信息（书号、书名、价格），
 * 每本图书信息占一行，书号、书名、价格用空格分隔，价格之后没有空格。
 * 最后第n+1行是输入结束标志：0 0 0（空格分隔的三个0）。其中书号和书名为字符串类型，价格为浮点数类型。
 */
public class MainLian01 {
    public static void main(String[] args) {
        //所以链式结构java怎么写的呢？
        Scanner sc = new Scanner(System.in);
        //新建一个大链表
        BookList01 bookList01 = new BookList01();
        while (sc.hasNext()){//当输入流里面还有下一个元素时
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            if(id.equals("0") && name.equals("0") && price == 0.0){
                break;
            }
            //每次进来一组信息创建一个book对象
            Book01 book01 = new Book01(id, name, price);
            bookList01.TrailAdd(book01);//尾插放入链表当中
        }
        bookList01.printInfo();
    }
}
//定义书本类
class Book01{
    private String id;
    private String name;
    private double price;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Book01(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
//由于是链表，需要再定义链表节点类,每个节点保存一个图书对象信息
class listNode{
    private Book01 data;//数据域注意数据类型是Book1
    private listNode next;//指针next注意数据类型是listNode
    //注意链表节点的构造器只传入数据，指针初始设置为空
    public listNode(Book01 data) {
        this.data = data;
        this.next = null;
    }
    //其中get set方法也只有对指针进行set？
    public Book01 getData() {
        return data;
    }
    //这一步其实意思是看后面还有没有节点
    public listNode getNext() {
        return next;
    }
    //这一步其实意思是向后走
    public void setNext(listNode next) {
        this.next = next;
    }
}
//对于链表的操作我们还需要一个BookList类来表示整个链表，并且链表类里面还要有插入和输出方法？
class BookList01{
    //设置两个属性：头节点方便操作，链表长度
    private listNode head;
    private int size;
    //构造器初始化链表

    public BookList01() {//注意无参构造器
        this.head = new listNode(null);//注意这里头节点是new出来的一个新节点，利用了节点的构造器传入data为空
        this.size = 0;
    }
    //链表信息的接收填充要选择合理的插入方法，头插法或尾插法，不像顺序表那样简单地接收，所以定义一个方法尾插
    //这里进行尾插，传入data即可(data代表着一本图书的全部信息）
    public void TrailAdd(Book01 data){
        listNode Node = new listNode(data);
        //尾插法，需要一个工作指针指向头节点，当头节点的下一个不为空时向后走，直到为空则插入
        //插入和向后走其实都在节点类中set get方法中体现
        listNode p = head;
        while (p.getNext() != null){
            p = p.getNext();
        }
        //为空了插入
        p.setNext(Node);
        size ++;//注意别忘了对规模进行处理，因为最后要输出规模的
    }
    //再提供一个输出信息的方法
    public void printInfo(){
        listNode p = head.getNext();
        System.out.println(size);
        //开始进行输出信息
        while (p != null){
            Book01 book01 = p.getData();//得到图书对象，图书对象里面包含了三个信息
            System.out.printf("%s %s %.2f",book01.getId(),book01.getName(),book01.getPrice());
            p = p.getNext();
        }
    }
}
