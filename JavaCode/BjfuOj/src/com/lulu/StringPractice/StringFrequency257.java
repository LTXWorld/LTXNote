package com.lulu.StringPractice;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 *写一个算法统计在输入字符串中各个不同字符出现的频度并将结果输出(字符串中的合法字符为A-Z之间的26个字母和0-9之间的10个数字)。
 * 输入：多组数据，每组数据有一行，为待统计字符频度的字符串。当字符串为“0”时，输入结束。
 * 输出：对于每组数据输出n行，每一行为一个字符出现的频度（只输出存在的字符，格式为：字符：频度），字符排列顺序按照ASCII码从小到大的顺序。
 *
 * 统计出现频度，可以考虑哈希表，键为唯一的字符串，值为出现的次数，但是本题字符以及数字个数有限，可以直接使用数组作为哈希表
 * 数组的下标可以用相对位置 - A 来表示；
 *
 *
 */
public class StringFrequency257 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] frequency = new int[36];
        while (true){
            String input = sc.nextLine();
            //退出循环条件
            if ("0".equals(input)){
                break;
            }
            for (int i = 0; i < input.length(); i++) {
                //对输入的字符进行频度的记录
                char c = input.charAt(i);
                if (c >= '0' && c <= '9'){
                    frequency[c - '0'] ++;
                }
                if (c >= 'A' && c <= 'Z'){
                    frequency[c - 'A' + 10] ++;
                }
            }
        }
        //此时还没有对结果进行ASCII排序？其实上面已经排好了
        //输出
        for (int i = 0; i < frequency.length; i++) {
            //这里还需要转换为字符
            char c = (char)(i < 10 ? i +'0' : i - 10 +'A');
            System.out.println(c+ ":" + frequency[i]);
        }
    }
}
