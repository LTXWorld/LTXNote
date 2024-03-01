package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test494
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/5 18:19
 */
public class Test494 {
    public static void main(String[] args) {

    }
}
class Solution494{
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (target < 0 && sum < -target) return 0;
        if ((target + sum) % 2 != 0) return 0;//背包容量必须是整除得到的，如果没有整除那一定得不到target
        int bagSize = (target + sum) / 2;
        if (bagSize < 0) bagSize = - bagSize;//这里还要保证背包容量必须是正数，因为后面的遍历
        //
        int[] dp = new int[bagSize + 1];
        //
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];
    }
}
