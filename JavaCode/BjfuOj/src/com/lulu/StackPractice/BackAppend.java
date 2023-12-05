package com.lulu.StackPractice;



import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author 陆涛
 * @version 1.0
 * 从键盘上输入一个后缀表达式，试编写算法计算表达式的值。规定：后缀表达式的长度不超过一行，以“=”作为输入结束，操作数之间用空格分隔，操作符只可能有+、−、*、/四种运算。
 * 输入：多组数据，每组数据一行，对应一个后缀算术表达式，每个表达式均以“=”结尾。当表达式只有一个“=”时，输入结束。
 * 输出：对于每组数据输出一行，为表达式的运算结果
 * 应该对于输入数据一行一行的处理
 * 后缀其实就是使用栈，数字入栈，运算符来操作数字，结果再入栈
 */
public class BackAppend {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
        while (true){
            String input = sc.nextLine();
            if (input.equals("=")){
                break;
            }
            System.out.println(BackCaculate(input));
        }
        sc.close();
    }
    public static double BackCaculate(String s){
        if(s.length() == 0){
            return 0;
        }
        //双端队列作为栈
        Deque<Double> stack = new ArrayDeque<>();
        s = s.trim();
        String[] tokens = s.split("\\s+");
        //
//        String[] tokens = splitExpression(s);
        for (String token: tokens){
            if ("=".equals(token)){
                return stack.pop();
            }else if ("+".equals(token)){
                stack.push(stack.pop() + stack.pop());
            }else if ("-".equals(token)){
                stack.push(-stack.pop() + stack.pop());
            }else if ("*".equals(token)){
                stack.push(stack.pop() * stack.pop());
            }else if ("/".equals(token)){
                double n1 = stack.pop();
                double n2 = stack.pop();
                stack.push(n2 / n1);
            }else {
                stack.push(Double.valueOf(token));
            }
        }
        //
        return stack.peek();
    }
//    private static String[] splitExpression(String expression) {
//        Matcher m = Pattern.compile("\\d+|[-+*/=]").matcher(expression);
//        return m.results().map(MatchResult::group).toArray(String[]::new);
//    }
}
