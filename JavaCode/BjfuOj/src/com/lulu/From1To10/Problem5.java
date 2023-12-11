package com.lulu.From1To10;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 多组a+b
 */
public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;
        while (sc.hasNext()){
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(a + b);//这样写每次输入完两个就输出，好像不大对，用一个数组接收一下？但是居然ac了
        }
        sc.close();
    }
}
