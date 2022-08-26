package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/8/23.
 */
public class LeetCode_55 {

    public static boolean canJump(int[] nums){

        boolean[] dp = new boolean[nums.length + 1];
        dp[0] = false;
        dp[1] = true;

        if(nums.length == 1)
            return true;

        for(int i = 0;i < nums.length;i ++){
            if(nums[i] == 0)
                break;

            for(int j = 0;j <= nums[i];j ++){
                if(i + j + 1 > dp.length - 1){
                    break;
                }
                dp[i + j + 1] = true;
            }
        }

        if(dp[dp.length - 1]){
            return dp[dp.length - 1];
        }
        return false;
    }

    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};
        System.out.println (canJump (nums));
    }
}
