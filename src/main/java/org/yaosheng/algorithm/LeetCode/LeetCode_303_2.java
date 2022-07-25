package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/7/25.
 */
public class LeetCode_303_2 {

    private int[] sum;   // sum[i]存储前i个元素和

    public LeetCode_303_2(int[] nums) {

        sum = new int[nums.length + 1];
        sum[0] = 0;
        for(int i = 1;i < sum.length;i ++)
            sum[i] = sum[i - 1] + nums[i - 1];
    }

    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
