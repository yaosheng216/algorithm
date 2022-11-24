package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/11/24.
 */
public class LeetCode_795 {

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {

        int ans = 0, n = nums.length;
        int maxR = -1, nor = -1;

        for(int i = 0; i < n; i ++){
            if(nums[i] > right){
                maxR = -1;
                nor = -1;
                continue;
            }
            if(nor == -1){
                nor = i;
            }
            if(nums[i] <= right && nums[i] >= left){
                ans += i - nor + 1;
                maxR = i;
                continue;
            }
            if(nums[i] < left){
                if(maxR != -1){
                    ans += maxR - nor + 1;
                }

            }
        }
        return ans;
    }
}
