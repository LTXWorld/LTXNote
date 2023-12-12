package com.lulu.From1To10;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 给你n个整数，求他们中所有奇数的和。
 * 输入数据包含多个测试实例，每个测试实例占一行，每行的第一个数为n，表示本组数据一共有n个数，接着是n个整数ai。n<=1000，ai<=1000。
 * 输出每组中的所有奇数的和，对于测试实例，输出一行。如果不存在奇数，则输出0。
 */
public class Problem09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int len = sc.nextInt();//这一行有多少个整数
            int sum = 0;
            //内层的循环处理每一行的数据
            while (len > 0){
                int num = sc.nextInt();
                if (num % 2 != 0){
                    sum += num;
                }
                len --;
            }
            System.out.println(sum);
        }
    }
}
