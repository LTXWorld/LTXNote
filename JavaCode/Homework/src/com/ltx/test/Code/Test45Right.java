package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test45Right
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/7 10:17
 */
public class Test45Right {
    public static void main(String[] args) {
        int[] nums = {7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3};
        Solution45R s = new Solution45R();
        s.jump(nums);
    }
}
class Solution45R {
    public int jump(int[] nums) {
        int coverIndex = 0;//当前覆盖范围的最远位置
        int nextCover = 0;//使用一个变量记录下一次的最大范围最远位置
        int result = 0;
        if (nums.length == 1) return 0;
        for (int i = 0; i < nums.length; i++) {//因为要看每一次的覆盖范围的终点是否已经到了最后位置
            nextCover = Math.max(i+nums[i],nextCover);
            if (i == coverIndex){//走到范围的末尾还不能走到结尾
                result ++;
                coverIndex = nextCover;
                if (nextCover >= nums.length-1) break;
            }
        }
        return result;
    }
}
