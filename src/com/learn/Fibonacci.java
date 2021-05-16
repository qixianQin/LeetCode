package com.learn;

/**
 * @Description: 动态规划学习, 斐波那契数列
 * @Author:qixian
 * @Date: 2021/5/16 11:23 上午
 * @Version: v1.0.0
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci(8));
        System.out.println(fibonacci2(8));
        System.out.println(fibonacci3(8));
        System.out.println(fibonacci4(8));
    }

    /**
     *  暴力递归解法
     *  时间复杂度： O(2^n)
     *  空间复杂度： O(1)  只有一个 fibonacci(n-1) + fibonnacci(n-2)
     *
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n -1) + fibonacci(n -2);
    }


    /**
     * 使用备忘录解法：  使用一个数组作为一个备忘录 记录信息
     * 时间复杂度： O(n)
     * 空间复杂度： O(n)
     * @param n
     * @return
     */
    public static int fibonacci2(int n) {
        if (n < 1) return 0;
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

    public static int helper(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * 使用 DP 数组的迭代 解法
     * 时间复杂度： O(n)
     * 空间复杂度： O(n)
     * @param n
     * @return
     */
    public static int fibonacci3(int n) {
        if (n < 1)  return 0;
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 优化使用 dp的 空间复杂度， 使用两个参数变量保存前两个变量值即可
     * @param n
     * @return
     */
    public static int fibonacci4(int n) {
        if (n < 1) return 0;
        if (n == 1 || n ==2) return 1;
        int pre = 1, current = 1;
        for (int i = 3; i <= n; i++) {
            int sum = pre + current;
            pre = current;
            current = sum;
        }
        return current;
    }


}
