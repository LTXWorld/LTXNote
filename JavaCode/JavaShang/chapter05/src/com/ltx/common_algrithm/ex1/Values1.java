package com.ltx.common_algrithm.ex1;

/**
 * ClassName: Values1
 * Package:com.ltx.common_algrithm.ex1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/24 15:28
 */
public class Values1 {
    public static void main(String[] args) {
        //初始化数组，
        int[] arr1 = new int[10];
        //通过循环对数组赋值
        for (int i = 0; i < 10; i++) {
            arr1[i] = (int) (Math.random() * (99 - 10 + 1) ) + 10;
        }
        //求最大最小值
        int MaxValue = arr1[0];
        for (int i = 1; i < 10; i++) {
            if(MaxValue < arr1[i]){
                MaxValue = arr1[i];
            }
        }
        System.out.println("最大值为" + MaxValue);
        int MinValue = arr1[0];
        for (int i = 1; i < 10; i++) {
            if(MinValue > arr1[i]){
                MinValue = arr1[i];
            }
        }
        System.out.println("最小值" + MinValue);
        //求总和
        int Sum = 0;
        for (int i = 0; i < 10; i++) {
            Sum += arr1[i];
        }
        System.out.println("总和=" + Sum);
        //求平均值
        double AverageValue = Sum / 10;

    }
}
/*
定义一个长度为10的数组，int类型，分别赋值随机整数，求其最大值，最小值，总和，平均值。随机值在10-99之间
 */
