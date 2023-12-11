package com.lulu.From1To10;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class Problem03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;//
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        max = a > b ? a : b;
        max = max > c ? max : c;
        System.out.println(max);
    }
}
