package com.ltx.October.Teat1876;

/**
 * ClassName: Solution1876
 * Package:com.ltx.October.Teat1876
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 19:42
 */
public class Solution1876 {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3){
            return 0;
        }
        int slow = 0;
        int fast = 0;
        int ret = 0;
        int len = 0;//长度为3,当len为2时就意味着已经有一个好字符了
        while (fast < s.length()){
            fast ++;
            if (s.charAt(fast) != s.charAt(slow) && s.charAt(fast) != s.charAt(fast - 1)){
                len ++;
                if (len == 2){//当满足条件之后slow和fast也要重置
                    ret ++;
                    len = 0;
                    slow ++;
                    fast = slow;
                }
            }else {
                //slow = fast;//那这里也不能这么草率，slow应该是一直指向当前子字符串的最前面的
                slow ++;
                fast = slow;
                len = 0;
            }
        }
        return ret;
    }
}
