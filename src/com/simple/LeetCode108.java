package com.simple;


/**
 * @Description: leetCode 108
 * @Author:qixian
 * @Date: 2021/4/18 5:52 下午
 * @Version: v1.0.0
 */
public class LeetCode108 {

    public static void main(String[] args) {
        System.out.println(sortedArrayToBST(new int[]{-10,-3,0,5,9}));
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mind = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mind]);
        root.left = helper(nums, left, mind - 1);
        root.right = helper(nums, mind + 1, right);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        private TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
