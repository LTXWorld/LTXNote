package com.lulu.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author LTX
 * @version 01
 * 这道题是删除对应位置上的图书，与上一道题很像。应该还是采用Arraylist里面的方法，delete吗？
 */
public class MainDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        //使用Arraylist
        ArrayList<BookDelete> bookD = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] info1 = sc.nextLine().split(" ");
            String id = info1[0];
            String name = info1[1];
            double price = Double.parseDouble(info1[2]);
            BookDelete bookDelete = new BookDelete(id, name, price);
            bookD.add(bookDelete);
        }

        //接收删除位置
        int indexDelete = sc.nextInt();
        sc.nextLine();

        //进行删除
        if (indexDelete > 0 && indexDelete <= n){
            bookD.remove(indexDelete - 1);
            for(BookDelete bookDelete : bookD){
                System.out.printf("%s %s %.2f\n",bookDelete.getId(),bookDelete.getName(),bookDelete.getPrice());
            }
        }else {
            System.out.println("Sorry，the position to be deleted is invalid!");
        }
    }
}
class BookDelete{
    private String id;
    private String name;
    private double price;

    public BookDelete(String id, String name, double price) {
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
