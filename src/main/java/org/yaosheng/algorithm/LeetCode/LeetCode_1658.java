package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2023/1/7.
 */
public class LeetCode_1658 {

    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        if (nums[0] > x && nums[n - 1] > x) {
            return -1;
        }
        if (nums[0] == x || nums[n - 1] == x) {
            return 1;
        }
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total < x) {
            return -1;
        }
        if (total == x) {
            return n;
        }
        int k = total - x;
        return getSubArr(nums, k);
    }

    // 滑窗模板
    public int getSubArr(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int res = -1;
        while (right < n) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            if (sum == k) {
                res = Math.max(res, right - left + 1);
            }
            right++;
        }
        return res == -1 ? -1 : n - res;
    }
}
