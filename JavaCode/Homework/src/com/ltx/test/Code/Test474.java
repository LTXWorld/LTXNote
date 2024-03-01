package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test474
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/5 19:41
 */
public class Test474 {
}
class solution474{
    public int findMaxForm(String[] strs, int m, int n){
        int[][] dp = new int[m + 1][n + 1];
        int zeroNum, oneNum;
        for (String str : strs) {//先遍历商品
            oneNum = 0;
            zeroNum = 0;
            for (char c : str.toCharArray()) {//讲过每个单独的字符串转为一个个的字符
                if (c == '0'){
                    zeroNum ++;
                }else {
                    oneNum ++;
                }
            }
            //再遍历背包，两个维度并且倒序遍历,初始化为背包的容量
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
