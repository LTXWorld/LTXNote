package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test198
 * Package:PACKAGE_NAME
 * Description:
 *198打家劫舍
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/23 09:42
 */
public class Test198 {

}
class Solution198{
    public int rob(int[] nums) {
        //健壮性判断
        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        //
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        //
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);//注意这里并不是真的要取i-1，而是i-1代表着其前面所累积的最大金额
        }
        return dp[nums.length-1];
    }
}
class Solution213{
    public int rob(int[] nums){
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        //分为两种情况
        int result1 = robAction(nums, 0, nums.length - 2);//要第0个元素
        int result2 = robAction(nums,1,nums.length - 1);//要最后一个元素
        return Math.max(result1,result2);
    }
    //将线性打家劫舍单独解耦成一个方法
    int robAction(int[] nums, int start, int end){
        if (start == end) return nums[start];
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
