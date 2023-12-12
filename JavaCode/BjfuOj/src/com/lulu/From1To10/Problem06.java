package com.lulu.From1To10;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 给出一个正整数 x，判断它是不是一个素数。
 * 每组测试包涵一个正整数 X(3 <= x <= 1000)，表示你要判断的数
 * 如果正整数 X 是素数，则输出 YES，否则输出 NO，输出在一行。
 * 提示：将 x 作为被除数，将 2 ~ x-1 各个整数先后作为除数，如果都不能被整除，则 x 为素数
 */
public class Problem06 {
    public static void main(String[] args) {
        /**
         * 提示的方法是不是有点烦琐了？
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int index = 2;
        boolean flag = false;
        while (index < n){
            if (n % index == 0){//如果找到了一个因子
                System.out.println("NO");
                flag = false;
                break;
            }else {//如果当前因子不能整除则继续找
                index ++;
                flag = true;
                continue;
            }
        }
        //如果flag一直为true，意味着没有找到可以整除的因子
        if (flag == true) System.out.println("YES");
        sc.close();
    }
}
