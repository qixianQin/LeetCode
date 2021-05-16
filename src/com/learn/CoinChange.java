package com.learn;

import java.util.Arrays;

/**
 * @Description: 动态规划学习，换零钱问题： 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，每种硬币的数量无限，再给一个总金额 amount，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，算法返回 -1
 * @Author:qixian
 * @Date: 2021/5/16 11:55 上午
 * @Version: v1.0.0
 */
public class CoinChange {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1,2,5}, 11));
        System.out.println(coinChange2(new int[]{1,2,5}, 11));
        System.out.println(coinChange3(new int[]{1,2,5}, 11));
    }


    /**
     * 暴力解法： 递归遍历所有可能解
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        return dp(amount, coins);
    }

    public static int dp(int n, int[] coins) {
        // base case
        if (n == 0) return 0;
        if (n < 0)  return -1;
        int result = Integer.MAX_VALUE;
        for (int i : coins) {
            int subResult = dp(n - i, coins);
            if (subResult == -1) {
                continue;
            }
            result = Integer.min(result, 1 + subResult);
        }
        if (result != Integer.MAX_VALUE) {
            return result;
        } else {
            return -1;
        }
    }


    /**
     *  备忘录 解法： 使用数组记录 所有可能值
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange2(int[] coins, int amount) {
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    public static int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }


    /**
     * 动态规划解法
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange3(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }


}
