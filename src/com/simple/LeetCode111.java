package com.simple;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 二叉树最小深度
 * @Author:qixian
 * @Date: 2021/5/30 2:58 下午
 * @Version: v1.0.0
 */
public class LeetCode111 {

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
//        System.out.println(minDepth(t3));
        System.out.println(minDepth2(t3));
        System.out.println(minDepth3(t3));
        System.out.println(minDepth4(t3));
    }

    /**
     * 错误解法
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null ) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        return Math.min(left, right) + 1;
    }

    public static int height(TreeNode root) {
        if (null == root) {
            return 0;
        } else {
            return Math.min(height(root.left), height(root.right)) + 1;
        }
    }

    /**
     * 采用深度优先算法  用深度优先搜索的方法，遍历整棵树，记录最小深度
     * 对于每一个非叶子节点，我们只需要分别计算其左右子树的最小叶子节点深度。这样就将一个大问题转化为了小问题，可以递归地解决该问题
     * 时间复杂度： O(N)
     * @param root
     * @return
     */
    public static int minDepth2(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        int minDep = Integer.MAX_VALUE;
        if (null != root.left) {
            minDep = Math.min(minDepth2(root.left), minDep);
        }

        if (null != root.right) {
            minDep = Math.min(minDepth2(root.right), minDep);
        }
        return minDep + 1;
    }

    static class QueueNode {
        TreeNode node;
        int depth;

        public QueueNode(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    /**
     * 广度优先算法
     * 当我们找到一个叶子节点时，直接返回这个叶子节点的深度。广度优先搜索的性质保证了最先搜索到的叶子节点的深度一定最小。
     * @param root
     * @return
     */
    public static int minDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<QueueNode> queue = new LinkedList<>();
        queue.offer(new QueueNode(root, 1));
        while (!queue.isEmpty()) {
            QueueNode nodeDepth = queue.poll();
            TreeNode node = nodeDepth.node;
            int depth = nodeDepth.depth;
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.offer(new QueueNode(node.left, depth + 1));
            }
            if (node.right != null) {
                queue.offer((new QueueNode(node.right, depth + 1)));
            }
        }
        return 1;
    }

    public static int minDepth4(TreeNode root) {
        if (null == root) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int level = 1;
        while(!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = deque.poll();
                if (cur.left == null && cur.right == null) {
                    return level;
                }
                if (cur.left != null) {
                    deque.offer(cur.left);
                }
                if (cur.right != null) {
                    deque.offer(cur.right);
                }
            }
            level ++;
        }
        return level;
    }


}
