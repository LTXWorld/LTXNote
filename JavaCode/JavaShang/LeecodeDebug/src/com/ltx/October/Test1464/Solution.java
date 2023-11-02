package com.ltx.October.Test1464;

/**
 * ClassName: Solution
 * Package:com.ltx.October.Test1464
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/2 20:06
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int j = 0;
        int sum = Integer.MIN_VALUE;
        for (int i = 0;j < nums.length ; i++) {
            j = i + 1;//重新设置j的值,j只要作为i后一个即可。
            while (j < nums.length){
                if ((nums[j] - 1) * (nums[i] - 1) > sum){
                    sum = (nums[j] - 1) * (nums[i] - 1);
                }
                j ++;//在这个while循环里找到了一个最大值
            }
        }
        return sum;
    }
}
