package com.simple;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 94. 二叉树的中序遍历
 * @Author:qixian
 * @Date: 2021/6/6 2:25 下午
 * @Version: v1.0.0
 */
public class LeetCode94 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
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
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2,  t3, null);
        TreeNode t1 = new TreeNode(1, null, t2);
//        List<Integer> result = inorderTraversal(t1);
        List<Integer> result = inorderTraversal3(t1);
        result.forEach(item -> {
            System.out.println(item);
        });
    }

    /**
     * 二叉树中序遍历:   递归解法
     * 按照访问左子树——根节点——右子树的方式遍历这棵树
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (null == root) {
            return new LinkedList<>();
        }
        List<Integer> result = new LinkedList<>();
        if (null != root.left) {
            traversal(root.left, result);
        }
        result.add(root.val);
        if (null != root.right) {
            traversal(root.right, result);
        }
        return result;
    }

    public static List<Integer>  traversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            traversal(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            traversal(root.right, result);
        }
        return result;
    }

    /**
     * 递归解法优化：  时间复杂度  O(N)
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inorder(result, root);
        return result;
    }
    public static void inorder(List<Integer> result , TreeNode root) {
        if (root == null) {
            return ;
        }
        inorder(result, root.left);
        result.add(root.val);
        inorder(result, root.right);
    }

    /**
     * 迭代方式处理二叉树遍历，  使用一个显示的堆栈来处理  时间复杂度：  O(N)
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }






}
