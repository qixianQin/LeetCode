package com.simple;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 144. 二叉树的前序遍历
 * @Author:qixian
 * @Date: 2021/6/6 4:38 下午
 * @Version: v1.0.0
 */
public class LeetCode144 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    /**
     *  二叉树 前序遍历，  递归解法
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inOrder(root, result);
        return result;
    }
    public static void inOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        inOrder(root.left, result);
        inOrder(root.right, result);
    }

    /**
     *  二叉树遍历， 迭代解决
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1, t2, t3);
//        List<Integer> result = preorderTraversal(t1);
        List<Integer> result = preorderTraversal2(t1);
        result.forEach(item -> {
            System.out.println(item);
        });

    }

}
