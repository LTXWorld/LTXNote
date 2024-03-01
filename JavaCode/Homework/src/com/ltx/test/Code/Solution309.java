package com.ltx.test.Code;

/**
 * ClassName: Solution309
 * Package:com.ltx.test.Code
 * Description:
 *含有冷冻期的多次买卖
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/28 10:03
 */
public class Solution309 {
    public int maxProfit(int[] prices){
        int len = prices.length;
        if (prices == null || len < 2){
            return 0;
        }
        int[][] dp = new int[len][4];//一共四个状态，持有，保持卖出，当天卖出，冷冻期
        dp[0][0] = -prices[0];//其他状态初始化都为0
        //
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][1] - prices[i], dp[i-1][3] - prices[i]));
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][3]);
            dp[i][2] = dp[i-1][0] + prices[i];
            dp[i][3] = dp[i-1][2];
        }
        //返回三个手中没有股票的状态
        return Math.max(dp[len-1][3], Math.max(dp[len-1][1], dp[len-1][2]));
    }
}
