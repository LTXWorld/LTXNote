package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test322
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/20 16:22
 */
public class Test322 {
}
class Solution322{
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //
//        for (int i : dp) {
//            i = max;
//        }
        //注意这两个for循环的区别。
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                //这里的条件判断没有想到
                if (dp[j-coins[i]] != max){
                    dp[j] = Math.min(dp[j],dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
