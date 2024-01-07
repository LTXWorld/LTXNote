import java.util.Map;

/**
 * ClassName: Test45
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/7 09:39
 */
public class Test45 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution45 solution45 = new Solution45();
        solution45.jump(nums);
    }
}
class Solution45 {
    public int jump(int[] nums) {
        int coverIndex = 0;
        int pre = 0;//使用一个变量记录上一次的范围
        int result = 0;
        if (nums.length == 1) return 0;
        for (int i = 0; i <= coverIndex; i++) {
            pre = coverIndex;
            coverIndex = Math.max(i + nums[i] ,coverIndex);
            if (coverIndex > pre){
                result ++;
            }
            if (coverIndex >= nums.length - 1) break;
            if (nums[coverIndex] + coverIndex >= nums.length-1){
                break;
            }
        }
        return result;
    }
}
