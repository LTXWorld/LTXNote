package com.lulu.From1To10;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 输入包含多组测试数据，每组测试数据包含两个正整数 a 和 b。
 * 输出 a 与 b 的和，输出在一行。
 */
public class Problem01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(a + b);

        sc.close();
    }
}
