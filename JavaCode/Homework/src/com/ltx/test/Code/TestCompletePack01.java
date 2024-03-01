package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.TestCompletePack01
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/10 13:58
 */
public class TestCompletePack01 {
    public static void main(String[] args) {

    }
}
class SolutionCp01{
    private static void testCompletePack(){
        int[] weight ={1, 3, 4};
        int[] value ={15, 20, 30};
        int bagWeight = 4;
        //初始化一维的dp数组，与01背包一样，都初始化为0
        int[] dp = new int[bagWeight + 1];
        //先遍历物品再遍历背包容量，即用每个物品先去填充背包
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int maxValue : dp) {
            System.out.println(maxValue + " ");
        }
    }
}
class SolutionCp02{
    private static void testCompletePack02(){
        int[] weight = {1, 3, 4};
        int[] value ={15, 20, 30};
        int bagWeight = 4;
        //
        int[] dp = new int[bagWeight + 1];
        //先遍历背包容量再遍历商品，每次都先定一个背包容量再把商品一个一个放进来试最大值
        for (int j = 0; j <bagWeight; j++) {
            for (int i = 0; i < weight.length; i++) {
                if (j - weight[i] >= 0) dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
    }
}
