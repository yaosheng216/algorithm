package org.yaosheng.algorithm.LeetCode;

import java.util.Arrays;

/**
 * Created by yaosheng on 2023/2/8.
 */
public class LeetCode_164 {

    public static int maximumGap(int[] nums) {

        Arrays.sort(nums);
        int res = 0;
        for (int i = 1;i < nums.length;i ++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10};
        System.out.println (maximumGap (arr));
    }
}
