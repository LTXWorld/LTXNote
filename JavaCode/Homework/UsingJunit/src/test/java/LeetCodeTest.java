import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * ClassName: LeetCodeTest
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/7 09:42
 */
public class LeetCodeTest {
    @Test
    public boolean isSubsequence392(String s, String t){
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        int len1 = chars1.length;
        int len2 = chars2.length;
        //
        int[][] dp = new int[len1 + 1][len2 + 1];
        //
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (chars1[i-1] == chars2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if (dp[len1][len2] == len1){
            return true;
        }
        return false;
    }

    //T115不同的子序列
    @Test
    public int numDistance(String s, String t){
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        //初始化,虽然只有一条语句，但其实有三个初始化1，0，1
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = 1;
        }
//        dp[0][0] = 1;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len1][len2];
    }

    //T583两个字符串的删除操作
    @Test
    public int minDistance(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        //
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        //
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+2));
                }
            }
        }
        return dp[len1][len2];
    }

    //T72编辑距离
    @Test
    public int minDistance2(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        //
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]+1));
                }
            }
        }
        return dp[len1][len2];
    }

    //T647
    @Test
    public int countSubstrings(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int result = 0;//用于计数
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (j-i <= 1){
                        dp[i][j] = true;
                        result ++;
                    }else if (dp[i+1][j-1]){
                        dp[i][j] = true;
                        result ++;
                    }
                }
            }
        }
        return result;
    }

    //T5
    @Test
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        //声明最大长度以及开始位置，结束位置可以由二者推出
        int maxLen = 0;
        int startIndex = 0;
        //
        for (int i = len-1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    if (j-i <= 1){
                        dp[i][j] = true;
                        if (j-i+1 > maxLen){
                            maxLen = j - i + 1;
                            startIndex = i;
                        }
                    }else if (dp[i+1][j-1]){
                        dp[i][j] = true;
                        if (j-i+1 > maxLen){
                            maxLen = j - i + 1;
                            startIndex = i;
                        }
                    }
                }
            }
        }
        return s.substring(startIndex,startIndex+maxLen);
    }


    //T516
    @Test
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        //
        for (int i = len-1; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {//这里与前面的不同，j从i后面开始,因为底下有j-1
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];//注意最后的返回结果，全范围内的最长回文子序列
    }
    //T739
    @Test
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];//声明结果数组
        //声明单调栈,单调栈中保存原数组的下标
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);//将下标0入栈
        //开始遍历温度数组
        for (int i = 1; i < len; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    //保证栈不为空并且现在的比较元素大于栈顶元素
                    result[stack.peek()] = i - stack.peek();//栈顶元素即需要赋值的下标位置，因为找到了第一个大于它的元素（的下标）
                    stack.pop();
                }
                stack.push(i);//如果不大于（或者栈已经为空了）需要将当前元素入栈，别忘记这一步。
            }
        }
        return result;
    }
    //T496
    @Test
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //声明结果数组与单调栈
        int[] result = new int[len1];
        Arrays.fill(result,-1);//根据题意初始化为-1
        //
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        //声明哈希表来保存nums1的反向映射关系
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len1; i++) {
            map.put(nums1[i],i);//key(值）-value（下标）
        }
        //
        for (int i = 1; i < len2; i++) {
            if (nums2[i] <= nums2[stack.peek()]){
                stack.push(stack.peek());
            }else {
                while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                    //如果此时2中的某个元素与1中相同（符合题意）
                    if (map.containsKey(nums2[stack.peek()])){
                        Integer index = map.get(nums2[stack.peek()]);
                        result[index] = nums2[i];//将2中下一个大的数填充结果数组
                    }
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return result;
    }
}
