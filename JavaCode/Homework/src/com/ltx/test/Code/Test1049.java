package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test1049
 * Package:PACKAGE_NAME
 * Description:
 *最后一块石头的重量II
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/1 10:00
 */
public class Test1049 {
    public static void main(String[] args) {

    }
}
class Solution1049{
    public int lastStoneWeightII(int[] stones) {
        //
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        //
        int target = sum / 2;
        int[] dp = new int[target + 1];
        //
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j-stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];//前面一段是另外一堆所能达到的最大价值，后面是这一堆的最大价值
    }
}
