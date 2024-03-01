package com.ltx.test.Code;

import java.util.Arrays;

/**
 * ClassName: com.ltx.test.Code.TestBag01
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/28 10:20
 */
public class TestBag01 {
    public static void main(String[] args) {

    }
}
class SolutionBag{
    /**
     *
     * @param weight 物品i的重量
     * @param value 物品i的价值
     * @param bagSize 背包的容量
     */
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        int goods = weight.length;
        int[][] dp = new int[goods][bagSize + 1];//行数是物品的数量（与物品的重量数组长度一致）列数是背包的容量从0开始
        //初始化
        for (int j = weight[0]; j <= bagSize; j++) {//这里取巧了，因为原本整个dp数组值都是0，我们其实只需要初始化第一行
            dp[0][j] = value[0];//初始化第一行的元素，并且从第0个的重量下标的位置开始初始化（从背包容量合适的位置开始）
        }
        //先遍历行，再遍历列；i代表的是物品是哪一个，j代表着此时背包的容量
        for (int i = 1; i < goods; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]){
                    //此时背包的容量不足以装下物品i
                    dp[i][j] = dp[i-1][j];
                }else {
                    //此时可以放下物品i，但是可以选择不放，也可以选择放，在这之间我们要选择一个最大值
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }
        //将dp数组打印出就可以看到不同情况下的最大价值
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));//将每一行打印出
        }
    }
}
