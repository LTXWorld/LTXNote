package com.lulu.From21To30;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 给出一个单词，把单词中的字母按反序输出，从最后一个字母到第一个字母依次输出。
 * 第一行是一个正整数N，代表输入数据的个数。下面N行每行有一个英文单词，单词的长度不会超过30。
 * 把每组数据中的英文单词反序输出，每个单词占一行。
 *
 */
public class Problem23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();//解决nextInt和nextLine之间的陷阱，这里接受掉换行符

        while (N  > 0){
            String word = sc.nextLine();//如果使用nextLine刚进来的时候word=''？
            Reverse(word);
            N --;
        }
        sc.close();
    }
    private static void Reverse(String word){
        //先将String转换为字符串数组
        char[] arr = word.toCharArray();
        int left = 0;
        int right = word.length() - 1;
        while (left < right){
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left ++;
            right --;
        }
        //将字符数组转换为字符串
        String result = new String(arr);
        System.out.println(result);
    }
}

