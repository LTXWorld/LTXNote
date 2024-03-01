package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test279
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/21 10:43
 */
public class Test279 {

}
class Solution279{
    public int numSquares(int n){
        int[] dp = new int[n + 1];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        //注意遍历商品时条件是i*i
        for (int i = 1; i*i <= n; i++) {
            for (int j = i*i; j <= n; j++) {
                dp[j] = Math.min(dp[j],dp[j - i*i] + 1);//即每个商品都是i*i，不是以前的nums[i]了。
            }
        }
        return dp[n];
    }
}
