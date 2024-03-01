package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test377
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/20 16:02
 */
public class Test377 {
}
class Solution377{
    public int combinationSum4(int[] nums, int target) {
        //
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j > nums[i]) dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
