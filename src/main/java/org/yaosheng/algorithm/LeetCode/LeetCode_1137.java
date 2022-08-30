package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/8/30.
 */
public class LeetCode_1137 {

    public static int tribonacci(int n) {

        if(n < 2)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for(int i = 3;i <= n;i ++){
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println (tribonacci (1));
    }
}
