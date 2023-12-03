package com.lulu.test;

import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 描述
 *
 * 定义一个包含图书信息（书号、书名、价格）的顺序表，读入相应的图书数据来完成图书信息表的创建，
 * 然后根据指定的最佳位置的序号，查找该位置上的图书，输出相应图书的信息。
 * 输入
 *
 * 总计n+m+2行。首先输入n+1行，其中，第一行是图书数目n，
 * 后n行是n本图书的信息（书号、书名、价格），每本图书信息占一行，书号、书名、价格用空格分隔，
 * 价格之后没有空格。其中书号和书名为字符串类型，价格为浮点数类型。然后输入m+1行，
 * 其中，第一行是一个整数m，代表查找m次，后m行每行内容为一个整数，代表待查找的图书的位置序号。
 *
 * 输出
 * 输出m行 若查找成功： 输出内容为第i次查询的指定位置上的一本图书的信息（书号、书名、价格），
 * 书号、书名、价格用空格分隔，其中价格输出保留两位小数。
 * 若查找失败： 只输出以下提示：抱歉，最佳位置上的图书不存在！
 */
public class MainBestPosition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BestBook[] books = new BestBook[n];
        //写入信息
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            double price = sc.nextDouble();
            books[i] = new BestBook(id,name,price);
        }
        //后面的m+1行
        int m = sc.nextInt();
        sc.nextLine();
        //最后m行内容为整数代表位置序号，并且发现序号从1开始。把这些内容存在一个数组当中？
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }
        //进行查找输出
        for (int i = 0; i < m; i++) {
            if(arr[i] > 0 && arr[i] <= n){
                //查找的位置序号即arr数组里面存放的值不能越界，界限是从1到n
                System.out.println(books[arr[i] - 1]);//这里下标要-1注意
            }else {
                //发生了越界，即没有找到
                System.out.println("Sorry, the book on the best position doesn't exist");
            }
        }
    }
}
class BestBook{
    private String id;
    private String name;
    private double price;

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

    public BestBook(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + String.format("%.2f",price);
    }
}
