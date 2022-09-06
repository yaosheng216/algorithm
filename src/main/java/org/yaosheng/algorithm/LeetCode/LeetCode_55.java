package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/8/23.
 */
public class LeetCode_55 {

    public static boolean canJump(int[] nums){

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for(int i = 0;i < nums.length;i ++){
            for(int j = 1;j <= nums[i];j ++){
                if(dp[i] && i + j < nums.length)
                    dp[i + j] = true;
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println (canJump (nums));
    }
}
