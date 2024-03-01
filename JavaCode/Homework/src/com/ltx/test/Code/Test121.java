package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test121
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/26 14:49
 */
public class Test121 {
}
class Solution121{
    public int maxProfit(int[] prices) {
        //初始化dp数组
        int[][] dp = new int[prices.length][2];
        dp[0][0] = - prices[0];
        dp[0][1] = 0;
        //遍历元素，状态转移
        for (int i = 0; i < prices.length; i++) {
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);//注意只能买一次，所以这里如果这时买入手里的金钱没有之前的未买入
            dp[i][0] = Math.max(dp[i-1][0], - prices[i]);//在这一天买入了，之前一定是没有买入的，所以没有那个dp[i-1][1]
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
class Solution122{
    public int maxProfit(int[] prices){
        int[][] dp = new int[prices.length][2];
        dp[0][0] = - prices[0];
        dp[0][1] = 0;
        //
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        return dp[prices.length-1][1];
    }
}

class Solution123{
    public int maxProfit(int[] prices){
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;//但是这几个等于0的可以不用写因为原本声明时就是0
        //
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i-1][1], dp[i][0] - prices[i]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i-1][4], dp[i-1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }
}

