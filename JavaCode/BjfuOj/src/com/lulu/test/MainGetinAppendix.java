package com.lulu.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 */
public class MainGetinAppendix {
    /**
     * 在正常的数组入时，我们最终超时，这是在日常编程中自己没有注意到的点
     * 所以在这里我们引入了arraylist来调用它的add方法直接进行插入，时间复杂度为1
     * 并且注意本题采用的接收策略不再是往常那样，而是一上来就根据空格进行了划分
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        //使用Arraylist,创建bookList数组保存，将每个对象塞入此数组当中
        ArrayList<BookI> bookList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            //这里使用split+nextLine对接收到的下一个字符串进行了按照空格划分，最终得到了一个字符串数组
            String[] info = sc.nextLine().split(" ");
            String id = info[0];
            String name = info[1];
            double price = Double.parseDouble(info[2]);//这里不用sc.nextdouble,为了精度
            BookI bookI = new BookI(id,name,price);
            bookList.add(bookI);
        }

        int index = sc.nextInt();
        sc.nextLine();

        //输入并暂存待插入图书信息，即使它的插入位置不对你也要在这里接收，因为要按照输入的顺序来
        String[] info2 = sc.nextLine().split(" ");
        String id = info2[0];
        String name = info2[1];
        double price = Double.parseDouble(info2[2]);
        BookI bookInsert = new BookI(id, name, price);

        //进行插入操作
        if (index > 0 && index <= n + 1){
            bookList.add(index - 1,bookInsert);//在list数组当中调用其add插入方法，位置，插入的东西
            //进行输出
            for (BookI bookI : bookList){
                System.out.printf("%s %s %.2f\n",bookI.getId(),bookI.getName(),bookI.getPrice());
            }
        }else {
            System.out.println("Sorry，the position to be inserted is invalid!");
        }

    }
}
class BookI{
    private String id;
    private String name;
    private double price;

    public void setId(String id) {
        this.id = id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public BookI(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
