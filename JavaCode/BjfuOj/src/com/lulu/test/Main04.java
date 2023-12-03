package com.lulu.test;

/**
 * @author LTX
 * @version 01
 */

import java.util.Scanner;

/**
 * 定义一个包含图书信息（书号、书名、价格）的顺序表，读入相应的图书数据来完成图书信息表的创建，
 * 然后将读入的图书信息逆序存储，逐行输出逆序存储后每本图书的信息。
 *输入n+1行，第一行是图书数目n，后n行是n本图书的信息（书号、书名、价格），
 * 每本图书信息占一行，书号、书名、价格用空格分隔，
 * 价格之后没有空格。其中书号和书名为字符串类型，价格为浮点数类型。
 * 总计n行，第i行是原有图书表中第n-i+1行的图书的信息（书号、书名、价格），
 * 每本图书信息占一行，书号、书名、价格用空格分隔。其中价格输出保留两位小数。
 */
public class Main04 {
    public static void main(String[] args) {
    //其实逆序存储的核心在于存储的时候下标问题，要注意输入的时候多了一行n，输出的时候少了一行
    //并且输入停止的限制不再是000，变成了以n作为限制输入
        Scanner sc = new Scanner(System.in);
        //读入图书的数量，这一步是与前面的题目不一样的点
        int n = sc.nextInt();
        if (n < 0){
            return;
        }
        //申请一个顺序表来存放所有图书信息,并将图书信息全部输入进去
        Book04[] bookList = new Book04[n];
        for (int i = 0; i < n; i++) {
            //注意要声明变量接收你所输入进来的东西
            String bookId = sc.next();
            String bookName = sc.next();
            double bookPrice = sc.nextDouble();
            bookList[i] = new Book04(bookId,bookName,bookPrice);
        }
        //接下来进行逆序输出
        for (int i = n - 1; i >= 0 ; i --) {
            System.out.print(bookList[i]);//这里直接输出是因为在book类当中我们添加了toString
            //手动换行？为什么直接ln不行？
            System.out.println();
        }
    }
}
//先写一个book类
class Book04{
    private String id;
    private String bookName;
    private double price;

    public Book04(String id, String bookName, double price) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " " + bookName + " " + String.format("%.2f",price);
    }
}

