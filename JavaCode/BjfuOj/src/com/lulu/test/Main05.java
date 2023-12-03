package com.lulu.test;

/**
 * @author LTX
 * @version 01
 */

import java.util.Scanner;

/**
 * 定义一个包含图书信息（书号、书名、价格）的顺序表，读入相应的图书数据来完成图书信息表的创建，
 * 然后查找价格最高的图书，输出相应图书的信息。
 * 总计输出m+1行，其中，第一行是最贵图书的数目（价格最高的图书可能有多本），后m行是最贵图书的信息，
 * 每本图书信息占一行，书号、书名、价格用空格分隔，其中价格输出保留两位小数。
 */
public class Main05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //先接收一下第一行的n
        int n =sc.nextInt();
        //创建图书数组，并将输入信息输入进去。这个数组保存的内容是图书对象
        Book05[] book05s = new Book05[n];
        for (int i = 0; i < n; i++) {
            book05s[i] = new Book05(sc.next(),sc.next(),sc.nextDouble());
        }
        //查找价格最高的图书，并且最后要返回一共有多少本价格最高的图书
        int m = 0;
        double MaxPrice = 0;
        for (int i = 0; i < n; i++) {
            if(book05s[i].bookPrice > MaxPrice){
                MaxPrice = book05s[i].bookPrice;//最终在这里得到了最高价
            }
        }
        //这里总感觉少了一步，怎么在找价格最高的过程中去统计一共有多少价格最高的书呢
        for (int i = 0; i < n; i++) {
            //又得遍历一次去找到m的数量
            if (book05s[i].bookPrice == MaxPrice){
                m ++;
            }
        }
        //输出相应信息,但是这样做的话怎么去定位到那几本价格最高的书呢
        System.out.println(m);
        for (int i = 0; i < n; i++) {
            if (book05s[i].bookPrice == MaxPrice){
                System.out.println(book05s[i]);
            }
        }
    }
}
class Book05{
    String bookIds;
    String bookNames;
    double bookPrice;
    //创建对应的初始化构造器
    public Book05(String bookIds, String bookNames, double bookPrice) {
        this.bookIds = bookIds;
        this.bookNames = bookNames;
        this.bookPrice = bookPrice;
    }
}
