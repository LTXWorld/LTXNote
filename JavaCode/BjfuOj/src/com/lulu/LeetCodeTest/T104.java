package com.lulu.LeetCodeTest;



/**
 * @author 陆涛
 * @version 1.0
 */
public class T104 {
    private int result;

    /**
     * 得到当前深度，注意depth的值在递归时是不同的。
     * @param node 当前结点
     * @param depth 当前深度
     */
    private void getDepth(TreeNode node, int depth){
        result = Math.max(depth,result);//中，每次得到当前的深度（最大高度）
        if (node == null) return;
        //左右，实现了前序遍历
        if (node.left != null){
            getDepth(node.left,depth + 1);
        }
        if (node.right != null){
            getDepth(node.right,depth + 1);
        }
    }
    public int maxDepth(TreeNode root){
        result = 0;
        if (root == null) return result;
        getDepth(root,1);
        return result;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x){
        val = x;
    }
}
