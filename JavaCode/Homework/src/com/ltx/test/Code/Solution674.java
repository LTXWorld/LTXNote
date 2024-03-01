package com.ltx.test.Code;

/**
 * ClassName: Solution674
 * Package:com.ltx.test.Code
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/1 09:14
 */
public class Solution674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        int max = 0;
        //
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
