package com.lulu.StringPractice;

import sun.reflect.generics.tree.Tree;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author 陆涛
 * @version 1.0
 */
public class StringFrequency257Another {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true){
            String input = sc.nextLine();//接受一行的输入结果
            //设置结束循环条件
            if ("0".equals(input)){
                break;
            }
            //得到输入结果的频度
            Map<Character, Integer> frequencyMap = calculateFrequency(input);
            //按照ASCII码排序并输出
            for (Map.Entry<Character,Integer> entry : frequencyMap.entrySet()){
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
        sc.close();
    }
    private static Map<Character,Integer> calculateFrequency(String input){
        //使用TreeMap自动排序
        Map<Character, Integer> frequencyMap = new TreeMap<>();
        for (char ch : input.toCharArray()){
            //判断字符是否是满足条件的字符
            if ((ch >= 'A' && ch <= 'Z') || (ch >='0' && ch <= '9')){//这里把数字也当作字符进行判断了吗？
                //将键值对放入频度Map中，如果没有出现过就是0
                frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0) + 1);
            }
        }
        return frequencyMap;
    }
}
