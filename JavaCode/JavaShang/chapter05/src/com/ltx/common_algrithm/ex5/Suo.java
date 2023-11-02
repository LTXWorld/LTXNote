package com.ltx.common_algrithm.ex5;

/**
 * ClassName: Suo
 * Package:com.ltx.common_algrithm.ex5
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/25 15:43
 */
public class Suo {
    public static void main(String[] args) {
        //删除数组中的指定下标位置上的元素
        int[] arr = new int[]{1,2,3,4,5,6,7};
        //有一种取巧的方法是将后面的值全部往前移动，最后剩下的位置置为0，第二种是新建数组，把前面的复制过去，后面的也弄进来
        int index = 4;
        int[] newArr = new int[arr.length - 1];
        for (int i = 0; i <index ; i++) {
            newArr[i] = arr[i];
        }
        //后面的弄进来有点复杂，在于数组元素的下标
        for (int i = index; i < arr.length; i++) {
            newArr[i - 1] = arr[i];//注意下标，
        }
        arr = newArr;
    }
}
