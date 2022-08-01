package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/8/1.
 * 动态规划
 */
public class LeetCode_53 {

    public static int maxSubArray(int[] nums) {

        int res = nums[0];
        int sum = 0;
        for(int num : nums){
            if(sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res,sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,7,-9,6};
        System.out.println (maxSubArray (arr));
    }
}
