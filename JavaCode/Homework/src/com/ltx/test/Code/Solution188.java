package com.ltx.test.Code;

/**
 * ClassName: Solution188
 * Package:com.ltx.test.Code
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/27 09:56
 */
public class Solution188{
    public int maxProfit(int k, int[] prices){
        int[][] dp = new int[prices.length][2 * k + 1];
        //初始化
        for (int i = 1; i < 2*k; i+=2) {
            dp[0][i] = -prices[0];
        }
        //遍历,注意正常的二维数组一定是双层for循环遍历
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 2*k; j+=2) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1] - prices[i]);//j为奇数时
                dp[i][j+1] = Math.max(dp[i-1][j+1], dp[i-1][j] + prices[i]);//j为偶数时
            }
        }
        return dp[prices.length-1][2*k];
    }
}
