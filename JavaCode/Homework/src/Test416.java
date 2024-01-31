/**
 * ClassName: Test416
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/31 19:42
 */
public class Test416 {
    public static void main(String[] args) {

    }
}
class Solution416{
    public boolean canPartition(int[] nums){
        //对本题中有特别需要的变量进行声明
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;//如果总和为奇数，那根本就不需要分割了
        int target = sum / 2;
        //声明dp数组，并进行初始化
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {//遍历物品
            for (int j = target; j >= nums[i]; j--) {//遍历背包容量,从后往前
                dp[j] = Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        //这里其实是自己没有理解的地方，具体到这道题里面来说该如何解释呢
        if (dp[target] == target) return true;//背包容量为target时，最大价值也为target
        return false;
    }
}
