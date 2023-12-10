package com.lulu.LeetCodeTest;

/**
 * @author 陆涛
 * @version 1.0
 */
public class T104Test {
    public static void main(String[] args) {
        T104 solution = new T104();
        //
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int maxDepth = solution.maxDepth(root);
        System.out.println("Maximum depth of the tree is "  + maxDepth);
    }
}
