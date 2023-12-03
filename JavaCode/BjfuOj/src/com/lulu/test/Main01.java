package com.lulu.test;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //读取图书数据
        String[] bookNums = new String[100];
        String[] bookNames= new String[100];
        double[] bookPrices= new double[100];
        //这里创建了三个数组来存储书号，书名，以及价钱,为什么不用一个book类呢
        int count = 0;
        //读取数据存放在数组当中
        while (true){
            //声明的这仨用来暂存输入的内容
            String bookNum = sc.next();
            String bookName = sc.next();
            double bookPrice = sc.nextDouble();
            if(bookNum.equals("0") && bookName.equals("0") && bookPrice == 0){
                break;
            }
            bookNums[count] = bookNum;
            bookNames[count] = bookName;
            bookPrices[count] = bookPrice;
            count ++;
        }
        //输出信息
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println(bookNums[i] + " " +bookNames[i] + " " + String.format("%.2f",bookPrices[i]));
        }
    }
}
