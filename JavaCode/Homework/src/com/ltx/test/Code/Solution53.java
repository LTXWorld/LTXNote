package com.ltx.test.Code;

/**
 * ClassName: Solution53
 * Package:com.ltx.test.Code
 * Description:
 *最大子数组和
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/4 10:07
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
//        int maxResult = Integer.MIN_VALUE;注意这里不能取最小值，因为要避免只有一个元素的情况
        int maxResult = nums[0];//要声明为第一个元素的大小
        //
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            maxResult = Math.max(maxResult, dp[i]);
        }
        return maxResult;
    }
}
