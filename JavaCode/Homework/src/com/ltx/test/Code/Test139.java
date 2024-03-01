package com.ltx.test.Code;

import java.util.HashSet;
import java.util.List;

/**
 * ClassName: com.ltx.test.Code.Test139
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/22 09:50
 */
public class Test139 {
}
class Solution139{
    public boolean wordBreak(String s, List<String> wordDict){
        //为什么要将list转换为hashset呢？
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //要求顺序，先遍历背包再遍历物品，注意从下标为1开始遍历，背包容量从1开始的
        for (int j = 1; j <= s.length(); j++) {
            for (int i = 0; i < j && dp[i]; i++) {//这里注意物品的上限在j处，因为我们遍历物品时其实是在找一个[i,j]的段是否满足
                if (set.contains(s.substring(i,j)) && dp[i]) dp[j] = true;
            }
        }
        return dp[s.length()];
    }
}
