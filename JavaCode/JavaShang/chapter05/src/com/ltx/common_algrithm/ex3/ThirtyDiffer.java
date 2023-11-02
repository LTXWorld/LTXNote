package com.ltx.common_algrithm.ex3;

/**
 * ClassName: ThirtyDiffer
 * Package:com.ltx.common_algrithm.ex3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/24 16:25
 */
public class ThirtyDiffer {
    public static void main(String[] args) {
        //生成一个数组，里面存放三十个随机数不能重复
        int[] arr2 = new int[30];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = (int) (Math.random() * 30) - 1;

            boolean flag = false;
            while(true){
                //for循环去找第一个重复值
                for (int j = 0; j < i; j++) {
                    if(arr2[j] == arr2[i]){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    arr2[i] = (int) (Math.random() * 30) - 1;
                    flag = false;
                    continue;//这个continue会走到哪里？继续while循环吗。
                    //答案是肯定的，会继续去while循环里去判断此时位置上的值与前面的值是否相同，如果不相同则会走到下面那个break
                }
                break;
            }
        }
        //遍历数组
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i] + " ");
        }
    }
}
