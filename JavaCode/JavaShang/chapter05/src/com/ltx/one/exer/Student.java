package com.ltx.one.exer;

import java.util.Scanner;

/**
 * ClassName: Student
 * Package:com.ltx.one.exer
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/23 16:08
 */
public class Student {
    public static void main(String[] args) {
        //1 从键盘输入学生的人数，根据人数确定数组的大小
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入学生人数");
        int nums = scan.nextInt();
        //2 依次输入学生成绩，并将成绩保存在数组中
        int[] score = new int[nums];
        int MaxScore = score[0];
        System.out.println("请输入" + nums + "个成绩");
        for (int i = 0; i < nums; i++) {
            score[i] = scan.nextInt();
            if(MaxScore < score[i]){
                MaxScore = score[i];
            }
        }
        //3 获取学生成绩的最大值
        System.out.println(MaxScore);
        //4 遍历数组元素，根据成绩的差值得到对应的等级

    }
}
