package com.simple;

/**
 * @Description: 平衡二叉树   给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * @Author:qixian
 * @Date: 2021/5/30 2:02 下午
 * @Version: v1.0.0
 */
public class LeetCode110 {


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){}
        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        TreeNode t20 = new TreeNode(20, t15, t7);
        TreeNode t9 = new TreeNode(9);
        TreeNode t3 = new TreeNode(3, t9, t20);

        System.out.println(isBalanced(t3));
        System.out.println(isBalanced2(t3));


    }


    /**
     * 递归遍历， 自顶向下递归， 只要有不一样的，就返回FALSE
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(high(root.left) - high(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }
    public static int high(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(high(root.left), high(root.right)) + 1;
        }

    }

    /**
     * 解法2 ： 递归遍历，  自底而上遍历，
     * @param root
     * @return
     */
    public static boolean isBalanced2(TreeNode root) {
        return height(root) >= 0;
    }

    public static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    /**
     *  优化
     * @param root
     * @return
     */
    public static int height2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight, rightHeight;
        if ((leftHeight = height2(root.left)) == -1 || (rightHeight = height2(root.right)) == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }




}
