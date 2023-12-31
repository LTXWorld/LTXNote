package com.lulu.LeetCodeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陆涛
 * @version 1.0
 */
public class T131Test {
    public static void main(String[] args) {
        Solution131 s131 = new Solution131();
        String s = new String();
        s = "aab";
        s131.partition(s);
    }
}
class Solution131 {
    private List<String> path = new ArrayList<>();
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracing(s,0);
        return result;
    }
    private void backtracing(String s,int startIndex){
        if (startIndex >= s.length()){
            //分割线来到了最后
            result.add(new ArrayList<>(path));//判断回文逻辑在加入path中
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s,startIndex,i)){
                //这里很重要，范围为什么在startindex,i之间
                String str = s.substring(startIndex,i + 1);
                path.add(str);
            }else {
                continue;
            }
            backtracing(s,i + 1);
            path.remove(path.size() - 1);
        }
    }

    /**
     * 判断是否为回文串，注意这里是左闭右闭区间
     * @param s
     * @param start
     * @param end
     * @return
     */
    private boolean isPalindrome(String s,int start,int end){
        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }
        return true;
    }
}
