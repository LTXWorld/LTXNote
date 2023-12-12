package com.lulu.From1To10;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 输入一个半径R，输出以R为半径的球的表面积。
 * 输入数据有多组，每组输入占一行，由一个实数R构成。R<=1000
 * 输出占一行，输出该球表面积，输出结果保留三位小数。
 */
public class Problem08 {
    private static final double PI = 3.1415927;//本题的一个小要求，提前定义PI的值
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            double r = sc.nextDouble();//注意，输入数据由实数组成
            double area = 4 * PI * r * r;
//            System.out.println("%.3f" area);//输出格式有限制，就不能使用println
            System.out.printf("%.3f%n",area);
        }
        sc.close();
    }
}
