/**
 * ClassName: Test376
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/5 10:45
 */
public class Test376 {
    public static void main(String[] args) {
        Solution376 s376 = new Solution376();
        int[] nums = new int[]{1,17,5,10,13,15,10,5,16,8};
        s376.wiggleMaxLength(nums);
    }
}
class Solution376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int up = 1, down = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }

        return Math.max(up, down);
    }
}
