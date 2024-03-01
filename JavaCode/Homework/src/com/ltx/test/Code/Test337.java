package com.ltx.test.Code;

/**
 * ClassName: com.ltx.test.Code.Test337
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/25 15:37
 */
public class Test337 {
}
class Solution337{
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            val = x;
        }
    }

    public int rob(TreeNode root){
        int[] dp = robTree(root);
        return Math.max(dp[0], dp[1]);
    }

    /**
     * 递归处理当前结点
     * @param cur 传入当前结点
     * @return 返回当前结点的dp数组
     */
    private int[] robTree(TreeNode cur){
        if (cur == null) return new int[2];//递归的终止条件
        //左右中后序遍历
        int[] left = robTree(cur.left);
        int[] right = robTree(cur.right);
        //中
        int value1 = cur.val + left[0] + right[0];//偷

        int value2 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);//不偷

        //最后返回的就是动态规划中的dp数组
        return new int[]{value2,value1};
    }
}
