package com.lulu.From21To30;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 给定一个n，求出[1,n]内所有能被3整除的数的个数。
 */
public class Problem21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (sc.hasNext()){
            int n = sc.nextInt();
            result = n / 3;
            System.out.println(result);
        }
        sc.close();
    }
}
