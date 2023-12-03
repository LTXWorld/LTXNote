package com.lulu.test;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 */
public class Main05Applend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        sc.nextLine();//消耗掉换行符
        //填充,但是不用去判断输入的格式嘛
        BookM[] book05s = new BookM[n];
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            book05s[i] = new BookM(id,name,price);
        }
        BookM[] mostExpensive = getMaxPrice(book05s);
        System.out.println(mostExpensive.length);//即m
        for(BookM bookM : mostExpensive){
            System.out.println(bookM);
        }
    }
    //将寻找价格最高的图书并返回其数量以及定位到它们写成一个方法
    public static BookM[] getMaxPrice(BookM[] bookMS){
        if(bookMS.length == 0){
            return new BookM[0];
        }
        double MaxPrice = Double.MIN_VALUE;
        int m = 0;
        for (int i = 0; i < bookMS.length; i++) {
            if (bookMS[i].getBookPrice() > MaxPrice){
                MaxPrice = bookMS[i].getBookPrice();
                m = 1;//这个方法非常巧妙，既能够找到价格最高的图书，又可以记录到有多少
                //一旦找到更高的，置为1，找到一样高的个数递增
            } else if (bookMS[i].getBookPrice() == MaxPrice) {
                m ++;
            }
        }
        //创建新数组保存这些价格最高的图书
        BookM[] result = new BookM[m];
        //遍历原数组将其放入新数组当中
        int index = 0;
        for (int i = 0; i < bookMS.length; i++) {
            if(bookMS[i].getBookPrice() == MaxPrice){
                result[index ++] = bookMS[i];
            }
        }
        return result;
    }
}
class BookM{
    private String bookId;
    private String bookName;
    private double bookPrice;

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public BookM(String bookId, String bookName, double bookPrice) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
    }

    @Override
    public String toString() {
        return bookId + " " + bookName + " " + String.format("%.2f",bookPrice);

    }
}
