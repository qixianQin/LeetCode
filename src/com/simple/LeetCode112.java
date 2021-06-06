package com.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 112. 路径总和
 * @Author:qixian
 * @Date: 2021/6/6 3:59 下午
 * @Version: v1.0.0
 */
public class LeetCode112 {

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

    public static void main(String[] args) {
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1, t2, t3);

        System.out.println(hasPathSum(t1, 3));
        System.out.println(hasPathSum2(t1, 3));
        System.out.println(hasPathSum3(t1, 3));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return order(root, new Integer(0), targetSum);
    }

    public static boolean order(TreeNode root, Integer result, int targetSum) {
        if (root.left != null) {
            result =  root.val;
            order(root.left, result, targetSum);
        }
        if (result == targetSum) {
            return true;
        }
        if (root.right != null) {
            result = root.val;
            order(root.right, result, targetSum);
        }
        if (result == targetSum) {
            return true;
        }
        return false;
    }

    /**
     * 广度优先搜索  ： 记录从根节点到当前节点的路径和，以防止重复计算。
     *
     * 这样我们使用两个队列，分别存储将要遍历的节点，以及根节点到这些节点的路径和即可。
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queNode = new LinkedList<>();
        Queue<Integer> queVal = new LinkedList<>();
        queNode.offer(root);
        queVal.offer(root.val);
        while(!queNode.isEmpty()) {
            TreeNode now = queNode.poll();
            int temp = queVal.poll();
            if (now.left == null && now.right == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (now.left != null) {
                queNode.offer(now.left);
                queVal.offer(now.left.val + temp);
            }
            if (now.right != null) {
                queNode.offer(now.right);
                queVal.offer(now.right.val + temp);
            }

        }
        return false;
    }

    public static boolean hasPathSum3(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        return hasPathSum3(root.left, targetSum - root.val) || hasPathSum3(root.right, targetSum - root.val);
    }
}
