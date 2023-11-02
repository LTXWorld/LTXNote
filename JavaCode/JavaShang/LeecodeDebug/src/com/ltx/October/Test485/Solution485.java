package com.ltx.October.Test485;

/**
 * ClassName: Solution485
 * Package:com.ltx.October.Test485
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/6 17:02
 */
public class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int slow = 0;
        int fast = 0;
        int n = nums.length;
        int max = Integer.MIN_VALUE;//真正要返回的值
        int maxTime = 0;//临时变量，临时存储当前的长度
        for (fast = 0; fast < n ;) {//把递增改了
            if (nums[fast] != 0){
                fast ++;//这里直接++对于示例二也不对，越过第二个0了
                //maxTime = fast - slow + 1;//每次遇到1都更新吗？，这样写遇到示例2就不对了
                maxTime ++;
            }else{
                max = Math.max(max,maxTime);
                //遇到0就该重新计算当前长度
                maxTime = 0;
                fast ++;
                slow = fast ;//因为slow指向0的下标后并没有记录此时最左边的1
            }
        }
        return Math.max(max,maxTime);
    }
}
