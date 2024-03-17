import org.junit.Test;

import java.util.*;

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

    //T503尝试
    @Test
    public int[] nextGreaterElements1(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result,-1);
        //
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < len; i++) {
            if (nums[i] <= nums[stack.peek()]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                    result[stack.peek()] = nums[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        //这样正常的操作完之后栈内会剩下一些找不到下一个最大的元素，如果有，也是成环前面的元素
//        while (!stack.isEmpty())
        return result;
    }
    //T503正解1
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result,-1);
        if (len == 1){
            return result;
        }
        //
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        //将每一个下标位置都改成i%len，即代表了在一圈中的每个位置。
        for (int i = 1; i < len * 2; i++) {
            if (nums[i%len] <= nums[stack.peek()]){
                stack.push(i%len);
            }else {
                while (!stack.isEmpty() && nums[i%len] > nums[stack.peek()]){
                    result[stack.peek()] = nums[i%len];
                    stack.pop();
                }
                stack.push(i%len);
            }
        }
        return result;
    }

    //
    @Test
    public int trap(int[] height) {
        int len = height.length;
        if (len <= 2) return 0;
        //
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        //
        int sumResult = 0;
        //
        for (int i = 1; i < len; i++) {
            if (height[i] <= height[stack.peek()]){
                stack.push(i);
            }else {
                while (! stack.isEmpty() && height[i] > height[stack.peek()]){
                    //当遇到栈顶比自己小的即mid，同时也将其出栈了。
                    int mid = stack.pop();
                    if (! stack.isEmpty()){//注意这里需要判断栈是否为空，如果为空代表着没有左边的元素了。
                        int left = stack.peek();//这里无需弹出左边元素，等着在while循环里继续比较就行。
                        int h = Math.min(height[left], height[i]) - height[mid];
                        int w = i - left - 1;
                        int square = h * w;//获得可接雨水的面积（横向操作）
                        if (square > 0) sumResult += square;
                    }
                }
                stack.push(i);
            }
        }
        return sumResult;
    }

    //T84
    @Test
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        //对数组进行填充0
        int[] newHeights = new int[len + 2];
        int newLen = newHeights.length;
        newHeights[0] = 0;
        newHeights[newLen-1] = 0;
        //先往两侧填充0，再将中间的数填充好
        for (int i = 0; i < len; i++) {
            newHeights[i+1] = heights[i];
        }
        heights = newHeights;//直接夺舍了？
        //
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int result = 0;//结果
        //
        for (int i = 1; i < newLen; i++) {
            if (heights[i] >= heights[stack.peek()]){
                //单调递减栈
                stack.push(i);
            }else {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                    //找到了右边第一个小的
                    int mid = stack.peek();
                    stack.pop();
                    //左边第一个小的在栈中，右边第一个小的即当前遍历到的元素
                    int left = stack.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                stack.push(i);
            }
        }
        return result;
    }

    @Test
    public String maximumOddBinaryNumber(String s) {
        int len = s.length();
        int oneNum = 0;//统计二进制中1的个数
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1'){
                oneNum ++;
            }
        }
        //对于只有一个1的逻辑如何处理？
//        if (oneNum <= 1){
//            ret
//        }
        StringBuilder result = new StringBuilder();
        //添加除了末尾1以外的1
        for (int i = 0; i < oneNum-1; i++) {
            result.append('1');
        }
        //添加其他0
        for (int i = 0; i < len-oneNum; i++) {
            result.append('0');
        }
        //这一句可以顺便处理只有一个1的逻辑并且加上末尾的1
        if (oneNum > 0){
            result.append('1');
        }
        return result.toString();
    }
    //T2369
    @Test
    public boolean validPartition(int[] nums) {
        //创建dp数组
        int len = nums.length;
        boolean[] dp = new boolean[len + 1];//多一个位置为了表示dp[0]
        dp[0] = true;
        //
        for (int i = 2; i <= len; i++) {
            //处理条件1：两个相等的数
            if (i >= 2 && nums[i-1] == nums[i-2]){
                dp[i] = dp[i] || dp[i-2];
            }
            //处理条件23，相同点在于二者都是长度为3的
            if (i >= 3 && ((nums[i-1] == nums[i-2] && nums[i-2] == nums[i-3]) ||
                          (nums[i-1] == nums[i-2]+1 && nums[i-2] == nums[i-3]+1) )){
                dp[i] = dp[i] || dp[i-3];
            }
        }
        return dp[len];
    }
    //T2834
    public int minimumPossibleSum1(int n, int target) {
        //初始化结果数组
        int[] result = new int[n];
        int current = 1;//记录真正加入到数组中的数
        int sum = 0;//最后的返回总和
        //i代表着结果数组下标，current代表当前想要加入的数，并且current是从1开始的连续正整数
        for (int i = 0; i < n; current++) {//如果current加入不成，就得往下一个数走，所以这里是current++
            //检查是否可以将当前的数加入到数组中
            boolean canAdd = true;
            for (int j = 0; j < i; j++) {
                if (result[j] + current == target){
                    canAdd = false;
                    break;//比较了数组中当前所有的数和当前要加入的数，二者之和是否等于目标值
                }
            }
            //
            if (canAdd){
                result[i] = current;
                sum += current;
                i ++;//只有成功添加才移动到数组的下一个为止。
            }
        }
        return sum;
    }
    //T2834正解
    public int minimumPossibleSum(int n, int target) {
        final int MOD = (int) 1e9 + 7;
        int m = target / 2;
        if (n <= m){
            return (int) ((long) (1+n) * n / 2 % MOD);
        }
        return (int) (((long) (1+m) * m / 2 +
                ((long) target + target + (n-m) - 1) * (n-m) / 2) %MOD);
    }
    //T2789Try
    public long maxArrayValue1(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return nums[0];
        }
//        int maxValue = 0;
        //
        for (int i = len-1; i > 0; i--) {//for循环这里可以不写i--吗，因为在内部的判断中进行i--
            if (nums[i] < nums[i-1]){
//                i --;
            }else {
                nums[i-1] = nums[i] + nums[i-1];
//                i --;
            }
        }
//        //接下来要找操作后的最大值，不一定是第一个元素（可能在中间）但是我直接去找整个数组的最大值也可以吗？
//        for (int i = 0; i < len; i++) {
//            maxValue = Math.max(maxValue, nums[i]);
//        }
//        return maxValue;
        return (long) nums[0];
    }

    //T2789Try
    @Test
    public long maxArrayValue(int[] nums) {
        int len = nums.length;
        long result = nums[len-1];//将末尾元素（或者首元素）作为结果值的初始化（我觉得这是个好习惯）
        for (int i = len - 1; i > 0; i--) {
            if (result >= nums[i-1]){
                result += nums[i-1];
            }else {
                //如果不大于当前元素，就证明后面贪心所加的元素都没这个大，那么结果就要换了
                result = nums[i-1];
            }
        }
        return result;
    }

    //T2129Try
    @Test
    public String capitalizeTitle1(String title) {
        int len = title.length();
        char[] chars = title.toCharArray();
        int start = 0;
        //
        for (int i = 0; i < len;) {
            int count = 0;//是否还需要一个起始位置来确定范围？
            while (chars[i] != ' '){
                //如果不等于空格就继续往后
                i ++;
                count ++;
            }
            //出这个while循环意味着遇到空格了
            if (count > 2){
                //变大写
            }else {
                //变小写
            }
            start = i + 1;
        }
        return " ";
    }
    //
    @Test
    public String capitalizeTitle(String title) {
        String[] words = title.split(" ");
        //
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() > 2){
               words[i] = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
            }else {
                words[i] = word.toLowerCase();//注意不能使用word，因为字符串的特点会让word指向一个新的字符串
            }
        }
        return String.join(" ",words);//这个方法可以将第二个参数由第一个参数拼接起来
    }

    //T2684
    @Test
    public int maxMoves(int[][] grid) {
        //声明dp数组
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        //初始化全部为0
        for (int j = 1; j < n; j++) {//先遍历行，再遍历列，并且列从第二列开始,因为要往前比较
            for (int i = 0; i < m; i++) {
//                int maxMove = -1;
                //这个fork循环可以检查前面的三个可能位置的情况
                for(int k = -1; k <= 1; k ++){
                    if (i + k >= 0 && i + k < m && grid[i + k][j-1] < grid[i][j]){
                        //保证这个位置在矩阵之内，并且满足大小条件
                        dp[i][j] = Math.max(dp[i][j], dp[i+k][j-1] + 1);
                    }
                }
//                dp[i][j] = maxMove;
            }
        }
        //去找到最终结果(为什么只需要从最后一列里面找呢）
        int maxMoves = 0;
        for(int i = 0; i < m; i ++){
            maxMoves = Math.max(maxMoves, dp[i][n - 1]);
        }
//        return maxMoves == -1 ? 0 : maxMoves;
        return maxMoves;
    }
}
