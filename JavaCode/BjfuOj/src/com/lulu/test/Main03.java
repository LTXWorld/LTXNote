package com.lulu.test;

/**
 * @author LTX
 * @version 01
 */

import java.util.Scanner;

/**
 描述
 定义一个包含图书信息（书号、书名、价格）的顺序表，读入相应的图书数据完成图书信息表的创建，然后计算所有图书的平均价格，
 将所有低于平均价格的图书价格提高20%，所有高于或等于平均价格的图书价格提高10%，最后逐行输出价格修改后的图书信息。
 输入
 输入n+1行，前n行是n本图书的信息（书号、书名、价格），每本图书信息占一行，书号、书名、价格用空格分隔，
 价格之后没有空格。最后第n+1行是输入结束标志：0 0 0（空格分隔的三个0）。其中书号和书名为字符串类型，价格为浮点数类型。
 输出
 总计n+1行，第1行是修改前所有图书的平均价格，后n行是价格修改后n本图书的信息（书号、书名、价格），
 每本图书信息占一行，书号、书名、价格用空格分隔。其中价格输出保留两位小数。
 */
public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //定义图书信息顺序表
        String[] bookNums= new String[100];
        String[] bookNames = new String[100];
        double[] bookPrices = new double[100];
        //读入相应的图书数据
        int n = 0;
        int sum = 0,averyPrice = 0;//这里把计算总价格放在输入信息这个操作里面
        while(true){
            String bookNum = sc.next();
            String bookName = sc.next();
            double bookPrice = sc.nextDouble();
            if(bookNum.equals("0") && bookName.equals("0") && bookPrice == 0){
                break;
            }
            bookNums[n] = bookNum;
            bookNames[n] = bookName;
            bookPrices[n] = bookPrice;
            sum += bookPrice;
            n++;
        }
        //计算所有图书的平均价格
        averyPrice = sum / n;
        //更改价格
        for (int i = 0; i < n; i++) {
            if(bookPrices[i] < averyPrice){
                //低于平均，提高百分之20
                bookPrices[i] *= 1.2;
            }else {
                bookPrices[i] *= 1.1;
            }
        }
        //这里少了这个要求输出平均价格。
        System.out.printf("%2.f\n",averyPrice);
        for (int i = 0; i < n; i++) {
            System.out.printf("%s %s %.2f\n",bookNums[i],bookNames[i],bookPrices[i]);
        }
    }
}

