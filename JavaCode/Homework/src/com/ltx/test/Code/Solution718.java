package com.ltx.test.Code;

/**
 * ClassName: Solution718
 * Package:com.ltx.test.Code
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/2 09:45
 */
public class Solution718 {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        int MaxResult = 0;
        //初始化其实都是0
        //遍历时注意dp数组的含义，所以范围从1-len可以等于长度
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                MaxResult = Math.max(MaxResult, dp[i][j]);//最大值不一定是最后的元素为结尾的
            }
        }
        return MaxResult;
    }
}
