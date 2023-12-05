package com.lulu.StackPractice;

/**
 * @author 陆涛
 * @version 1.0
 */
public class TestClass {
    public static void main(String[] args) {
        String s = "1 2+8 2-7 4-/*=";
        s = s.trim(); // 这是必要的，以确保trim()的效果被应用
        String[] tokens = s.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            System.out.println(tokens[i]);
        }
    }
}
