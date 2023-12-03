package com.lulu.test03Stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author LTX
 * @version 01
 * 从键盘上输入一个后缀表达式，试编写算法计算表达式的值。
 * 规定：后缀表达式的长度不超过一行，以“=”作为输入结束，
 * 操作数之间用空格分隔，操作符只可能有+、−、*、/四种运算。
 *
 * 有错误。
 */
public class Stack02HouZhui {
    public static void main(String[] args) {
        //将收到的一行后缀表达式进行遍历，如果遇到操作数入栈，如果遇到操作符进行操作
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String expression = sc.nextLine();
            if(expression.equals("=")){
                break;
            }
            double result = evaluate(expression);
            System.out.println(result);
        }
    }
    private static double evaluate(String expression){
        Stack<Double> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);//将字符串转换为一个个字符数组
            if(c >='0' && c <= '9'){
                stringBuilder.append(c);//如果是操作数的话，将这个操作数字符放入到bulider中
            } else if (c =='+' || c=='-' || c=='*' || c=='/') {
                if(!stack.isEmpty()){
                    double num2 = stack.pop();
                    double num1 = stack.pop();
                    double result = 0.0;
                    switch (c){
                        case '+' : result = num2 + num1;break;
                        case '-' : result = num2 - num1;break;
                        case '*' : result = num2 * num1;break;
                        case '/' : result = num2 / num1;break;
                    }
                    stack.push(result);//计算完的结果入栈
                }
            } else if (c ==' ') {//如果字符为空格的话
                if(stringBuilder.length() > 0){
                    double num = Double.parseDouble(stringBuilder.toString());
                    stack.push(num);
                    stringBuilder.setLength(0);
                }
            } else if (c =='=') {//表达式为等号时，代表这一行完成。
                break;
            }
        }
        return stack.pop();//最后将结果输出
    }
}
