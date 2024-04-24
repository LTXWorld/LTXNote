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
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
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

    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     * @param nums
     * @param target
     * @return
     */
    @Test
    public int search(int[] nums, int target){
        //方法一，暴力for循环，时间复杂度为n
        //方法二，由于升序，元素不重复，先去中间找，大于向右，小于向左；并且找的逻辑每次都是向中间
        //需要双指针来表征位置
        int len = nums.length;
        int left = 0;
        int right = len - 1;//右边是n还是n-1？
        int mid = right - (right - left) / 2;//(right + left) / 2
        while (nums[mid] != target){
            if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return mid;
    }
    //T27移除元素,原地移除所给的元素在数组中
    @Test
    public int removeElement(int[] nums, int val){
        /**
         *没有一点思路当时
         */
        return 0;
    }
    //T977有序数组的平方，时间复杂度为n的方法
    @Test
    public int[] sortedSquares(int[] nums){
        //如果按照直接的思路，先全部平方然后再排序数组，这个时间复杂度是？
        /**
         * 我的思路是从后往前去比较，比两头如果后面的平方比前面的平方小，就交换二者位置上的元素
         * 但是工作指针是一直在后面元素下的，前面的元素不用动；相当于先排完序了再去全部平方
         * 这个时间复杂度是两次的遍历，2n也是n吧
         */
        int len = nums.length;
        for(int index = len - 1; index > 0; index --){
            if (nums[index] * nums[index] < nums[0]*nums[0]){
                //交换二者位置上的元素
                int temp = nums[0];
                nums[0] = nums[index];
                nums[index] = temp;
            }
        }
        //经历这个for循环之后，已经按照平方排好序了
        for (int i = 0; i < len; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }

    @Test
    public void HashsMap(){
        HashMap<Object, Object> map = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
    }
    //水果成篮
    @Test
    public int totalFruit(int[] fruits){
////        如果按照长度最小的子数组对照来看，本题所求的就是长度最大的连续子数组（只有两个数值）
//        int end = 0;
//        int modCount = 0;//几个数值
//        int result = Integer.MIN_VALUE;
//        //
//        for (int start = 0; start < fruits.length; start++) {
//            modCount ++;
//            while (modCount > 2){
//                //当存在超过2个数值，只移动end？
//                result = Math.max(result, end - start);
//            }
//        }
        //使用哈希表+滑动窗口，不满足条件时剔除前面的元素
//        key是水果类型（即数组值），value是该值的下标
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxResult = 1;
        int i = 0, j = 0;//i指向前面，j指向后面
        //
        while (j < fruits.length){
            //当哈希表中长度不超过2，意味着满足条件
            if (map.size() <= 2){
                map.put(fruits[j], j ++);
            }
            //当哈希表长度超过2，意味着有至少3种类型出现，需要进行滑动窗口的剔除（要找到其下标）
            if (map.size() > 2){
                int min = fruits.length - 1;
                for (Integer value : map.values()) {
                    min = Math.min(min, value);
                }
                i = min + 1;//i代表新的位置
                map.remove(fruits[min]);
            }
            //
            maxResult = Math.max(maxResult, j - i);
        }
        return maxResult;

    }

    /**
     * 59生成螺旋矩阵，设置好边界，按照向右向下向左向上的顺序，进行设置与缩减边界
     * @param n
     * @return
     */
    @Test
    public int[][] generateMatrix(int n){
//        声明结果矩阵并设置边界值
        int[][] result = new int[n][n];
        int num = 1;
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
//      按照顺序设置值
        while (num <= n * n){
//          向右填充，并缩减上边界（谁被填满就缩减谁）
            for(int i = left; i <= right && num <= n * n; i ++){
                result[top][i] = num ++;
            }
            top ++;
//          向下填充，并缩减右边界
            for (int i = top; i <= bottom && num <= n * n; i ++){
                result[i][right] = num ++;
            }
            right --;
//          向左填充，缩减下边界
            for (int i = right; i >= left && num <= n * n; i --){
                result[bottom][i] = num ++;
            }
            bottom --;
//          向上填充,缩减左边界
            for (int i = bottom; i >= top && num <= n * n; i--) {
                result[i][left] = num ++;
            }
            left ++;
        }
        return result;
    }

    /**
     * 54顺时针取出矩阵中的元素（矩阵本身并不螺旋）
     * @param matrix m * n的矩阵
     * @return
     */
    @Test
    public List<Integer> spiralOrder(int [][] matrix){
//        设置边界条件
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;//行列值
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = m - 1;
//      遍历取出元素，放入list中返回
        while (left <= right && top <= bottom){//结束条件应该是由原矩阵的长度所限制
//            四个方向取出元素，取出后缩减范围
            for (int i = left; i <= right ; i++) {
                list.add(matrix[top][i]);
            }
            top ++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right --;
//          当矩阵至少有两行或者两列时，才可以进行向左移动和向上移动（可以想象单行单列）
            if (top <= bottom){
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);
                }
                bottom --;
            }
            if (left <= right){
                for (int i = bottom; i >= top; i --) {
                    list.add(matrix[i][left]);
                }
                left ++;
            }
        }
        return list;
    }

    /**
     * 在单链表中删除值为val的元素
     * @param head 头结点
     * @param val 给定值
     * @return
     */
    @Test
    public ListNode removeElements(ListNode head, int val){
        /**
         * 删除某个元素一定要保留其前面位置和后面位置，所以一定需要工作指针和辅助指针
         * 为了保证头结点的操作统一，需要设置虚拟头结点
         */
        if (head == null){
            return null;
        }
        //设置虚拟头结点，辅助指针和工作指针
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        ListNode cur = head;
        //
        while (cur != null){
            if (cur.val != val){
                pre = pre.next;
                cur = cur.next;
            }else {
                pre.next = cur.next;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 设计链表
     */
    class MyLinkedList{
        //类的成员变量,链表的长度与虚拟头结点
        int size;
        ListNode dummyHead;
//        此类的构造方法
        public MyLinkedList() {
            size = 0;
            dummyHead = new ListNode(0);
        }
//      获取链表第index索引处的值，如果无效则返回-1（从0开始的索引）
        public int get(int index) {
            if (index < 0 || index >= size){
                return -1;
            }
            /**
             * 一个工作指针来遍历链表,找到索引位置
             */
            ListNode cur = dummyHead;
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
            return cur.val;
        }
//      头插法，在链表第一个元素之前插入值为val的元素
        public void addAtHead(int val) {
            ListNode curNode = new ListNode(val);//当前要插入的节点
            curNode.next = dummyHead.next;
            dummyHead.next = curNode;
            size ++;
        }
//      尾插法，将值为val的节点插入到链表的末尾
        public void addAtTail(int val) {
            ListNode cur = dummyHead;//cur先来到最后一个结点的位置
            while (cur.next != null){
                cur = cur.next;
            }
            ListNode node = new ListNode(val);
            cur.next = node;
            size ++;
        }
//      在链表的第index节点之前添加值为val的节点
        public void addAtIndex(int index, int val) {
            /**
             * 需要确定这个位置前后的节点
             */
            if (index > size){
                return;
            }
            if (index < 0){
                //要求小于0在头部插入，其实只要把index置为0，跟普通插入没区别
                index = 0;
            }
            //进行插入,pre指针定在插入位置之前
            ListNode pre = dummyHead;
            for (int i = 0; i < index; i++) {
                pre = pre.next;//pre来到要插入的节点之前
            }
            ListNode node = new ListNode(val);
            //
            node.next = pre.next;
            pre.next = node;
            size ++;
        }
//      如果索引有效，删除索引为index的节点
        public void deleteAtIndex(int index) {
            if (index < 0 || index > size-1){
                return;
            }
            //
            ListNode pre = dummyHead;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            //
            pre.next = pre.next.next;
            size --;
        }
    }
}
