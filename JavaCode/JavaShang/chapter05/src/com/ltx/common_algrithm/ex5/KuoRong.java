package com.ltx.common_algrithm.ex5;

/**
 * ClassName: KuoRong
 * Package:com.ltx.common_algrithm.ex5
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/24 22:37
 */
public class KuoRong {
    //将数组长度扩容一倍，并将10，20，30加到数组当中
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        int[] newArr = new int[arr.length << 1];
        //扩容数组得新建数组
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = 10;
        newArr[arr.length + 1] = 20;
        newArr[arr.length + 2] = 30;

        arr = newArr;

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
