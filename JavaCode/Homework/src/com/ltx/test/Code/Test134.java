package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test134
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/8 10:54
 */
public class Test134 {
    public static void main(String[] args) {
        int[] gas = new int[]{1,2,3,4,6};
        int[] cost = new int[]{3,4,5,1,2};
        Solution134 s = new Solution134();
        s.canComplete(gas,cost);
    }
}
class Solution134{
    public int canComplete(int[] gas,int[] cost){
        int curSum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            int rest = gas[i] - cost[i];
            curSum += rest;
            if (curSum < min){
                min = curSum;
            }
        }
        //分为三种情况
        if (curSum < 0) return  -1;
        if (min >= 0) return 0;
        //情况3，从后往前找能够填平的位置
        for (int i = gas.length - 1; i>= 0; i--) {
            int rest = gas[i] - cost[i];
            min += rest;
            if (min >= 0) return i;
        }
        return -1;
    }

}
