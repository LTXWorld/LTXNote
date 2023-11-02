package com.ltx.search_sort.bubbleSort;

/**
 * ClassName: Bubble
 * Package:com.ltx.search_sort.bubbleSort
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/25 16:01
 */
public class Bubble {
    public static void main(String[] args) {
        int[] arr = new int[]{6,9,2,9,1};
        for (int i = 1; i < arr.length ; i++) {
            for (int j = 0; j < arr.length - i; j++) {//上面i为1，这里长度-1都是为了可以每一次少比较最后一个元素，因为最后的元素已经最大了
                if(arr[j] > arr[j + 1]){
                    //从前往后进行依次比较
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        //当然还有进阶的方法，判断这个数组是否已经有序可以避免已经有序之后再次比较。
    }
}
