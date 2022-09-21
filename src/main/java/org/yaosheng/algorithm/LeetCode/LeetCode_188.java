package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/9/21.
 * 买卖股票的最佳时机IV
 */
public class LeetCode_188 {

    public int maxProfit(int k, int[] prices) {

        if (prices.length == 0)
            return 0;

        int len = prices.length;
        int[][] dp = new int[len][k * 2 + 1];

        for (int i = 1; i < k * 2; i += 2) {
            dp[0][i] = -prices[0];
        }

        for (int i = 1; i < len; i ++) {
            for (int j = 0; j < k*2 - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[len - 1][k * 2];
    }
}
