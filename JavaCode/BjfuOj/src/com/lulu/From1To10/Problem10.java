package com.lulu.From1To10;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 * 每个单词的第一个字母改成大写
 */
public class Problem10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            //我该怎样接收一个字符串，且字符串如果是String类型要注意他是不可变的，是否需要用一个可变的Builder
            String input = sc.nextLine();
            System.out.println(capitalizeFirstLetter(input));
        }
        sc.close();
    }
    private static String capitalizeFirstLetter(String sentence){
        String[] words = sentence.split(" ");// 用于根据空格分割句子为单词。
        StringBuilder capitalizedSentence = new StringBuilder();//由于字符串是不可变的，需要使用可变的Builder来处理
        for (String word : words){
            if (! word.isEmpty()){
                //进行首字母大写操作,注意substring可以取出特定的字符
                String capitalizedWord = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
                capitalizedSentence.append(capitalizedWord).append(" ");//将处理完的单词放入到句子中，每次都使用空格分割
            }
        }
        return capitalizedSentence.toString().trim();//去除开头和末尾的空格
    }
}
