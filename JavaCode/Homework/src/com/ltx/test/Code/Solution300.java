package com.ltx.test.Code;

/**
 * ClassName: Solution674
 * Package:com.ltx.test.Code
 * Description:
 *最长连续递增序列
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/1 08:32
 */
public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        //初始化dp数组
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        int max = Integer.MIN_VALUE;
        //进行遍历
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);//注意这里其实是在比较每个dp[j]+1
                }
                max = Math.max(max,dp[i]);
            }
//            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
