package com.ltx.test.Code;

import java.util.Arrays;

/**
 * ClassName: com.ltx.test.Code.Test455
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/5 09:08
 */
public class Test455 {
    public static void main(String[] args) {
        Solution455 s455 = new Solution455();
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        s455.findContentChildren(g,s);
    }
}
class Solution455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int res = 0;
        int index = s.length - 1;
        //大胃口需要大饼干
        for (int i = g.length - 1; i > 0 ; i--) {
            if (index > 0 && s[index] >= g[i]){//注意控制index
                res ++;
                index --;
            }
        }
        return res;
    }
}
