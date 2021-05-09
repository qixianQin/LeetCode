package com.common;



/**
 * @Description: Tree Node
 * @Author:qixian
 * @Date: 2021/4/18 5:55 下午
 * @Version: v1.0.0
 */
public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    private TreeNode() {}

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
