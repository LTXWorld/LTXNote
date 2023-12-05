package com.lulu.StackPractice;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author LTX
 * @version 01
 * 输入一个整数序列a1,a2,a3...,an。当ai不等于-1时将ai进栈；当ai=-1时，输出栈顶元素并将其出栈。
 * 多组数据，每组数据有两行，第一行为序列的长度n，第二行为n个整数，整数之间用空格分隔。当n=0时输入结束。
 * 对于每一组数据输出若干行。每行为相应的出栈元素。当出栈异常时，输出“POP ERROR”并结束本组数据的输出。
 *
 * java中对于栈是怎么定义的？对于数据的接收，先收到一个整数长度，下一行以空格分开，遇到-1进行出栈
 * 遇到不是-1的入栈，并且每两行就要创建一个新栈。
 */
public class Stack01 {
    //使用Stack类来实现
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){//当还有输入的时候
            int n = sc.nextInt();
            if (n == 0){
                break;
            }
            //每接收到一个n就创建一个新栈
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                int x =sc.nextInt();
                if (x != -1){
                    stack.push(x);//入栈
                }else {
                    if(stack.isEmpty()){
                        System.out.println("POP ERROR");
                        break;
                    }else {
                        System.out.println(stack.pop());
                    }
                }
            }
        }
        sc.close();
    }
}
