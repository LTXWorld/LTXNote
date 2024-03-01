package com.ltx.test.Code;

/**
 * ClassName: Solution714
 * Package:com.ltx.test.Code
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/29 09:19
 */
public class Solution714 {
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        //
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i] - fee);
        }
        return dp[len-1][1];
    }
}
