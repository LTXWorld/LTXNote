package com.ltx.common_algrithm.ex4;

/**
 * ClassName: TransAction
 * Package:com.ltx.common_algrithm.ex4
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/24 17:06
 */
public class TransAction {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,4,5,6,7,8,9,10};
        int len = arr1.length;
        for (int i = 0; i <len/2 ; i++) {
            //进行交换，注意下标
            int temp = arr1[i];
            arr1[i] = arr1[len - i - 1];
            arr1[len - i -1] = temp;
        }
        for (int i = 0; i < len; i++) {
            System.out.println(arr1[i]);
        }
    }
}
/*
翻转数组，将一半设置为条件，首尾移动开始调换——调换过程可以使用两种方法：两个指针或者单一参数i用长度减掉即可。
 */