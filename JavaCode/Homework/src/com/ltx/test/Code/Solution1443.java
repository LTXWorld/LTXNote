package com.ltx.test.Code;

/**
 * ClassName: Solution1443
 * Package:com.ltx.test.Code
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/2 13:41
 */
public class Solution1443 {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        //
        int len1 = chars1.length;
        int len2 = chars2.length;
        //
        int[][] dp = new int[len1 + 1][len2 + 1];
        //
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (chars1[i-1] == chars2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
