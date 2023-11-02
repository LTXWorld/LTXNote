package com.ltx.October.Test485;

/**
 * ClassName: Solution485s
 * Package:com.ltx.October.Test485
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/6 17:25
 */
public class Solution485s {
    public int findMaxConsecutiveOnes(int[] nums){
        int maxR = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                maxR ++;
            }else{
                max = Math.max(max,maxR);
                maxR = 0;
            }
        }
        return Math.max(max,maxR);
    }
}
