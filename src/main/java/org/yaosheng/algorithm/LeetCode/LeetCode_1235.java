package org.yaosheng.algorithm.LeetCode;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/10/22.
 */
public class LeetCode_1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int len = startTime.length;
        Integer[] start = new Integer[len];
        for (int i = 0;i < len;i ++)
            start[i] = i;

        Arrays.sort(start,(a, b) -> endTime[a] - endTime[b]);
        int[] dp = new int[len + 1];
        for (int i = 1;i <= len;i ++) {
            int k = i - 2;
            while (k >= 0 && endTime[start[k]] > startTime[start[i - 1]])
                k --;

            int m = k < 0 ? 0 : dp[k + 1];
            dp[i] = Math.max(dp[i - 1],m + profit[start[i - 1]]);
        }
        return dp[len];
    }
}
