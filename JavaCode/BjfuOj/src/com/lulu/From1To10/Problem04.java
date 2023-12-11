package com.lulu.From1To10;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class Problem04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        //判断闰年的逻辑
        if ((year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
        sc.close();
    }
}
