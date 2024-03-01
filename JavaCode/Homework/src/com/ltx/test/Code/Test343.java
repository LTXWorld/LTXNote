package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test343
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/24 09:21
 */
public class Test343 {

}
class Solution343{
    public int integerBreak(int n){
        //初始化dp数组
        int[] dp = new int[n+1];
        dp[2] = 1;
        //遍历
        for (int i = 3; i < n+1; i++) {
            for (int j = 1; j < i; j++) {//内层循环相当于对数字i进行拆分，先定j再拆后面的
                dp[i] = Math.max(Math.max(j * (i-j), j * dp[i-j]),dp[i]);//一个是拆成两个数，一个是继续拆第二个数，产生更多的数
            }
        }
        return dp[n];
    }
}
