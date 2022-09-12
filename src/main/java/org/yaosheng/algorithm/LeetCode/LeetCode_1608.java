package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/9/12.
 */
public class LeetCode_1608 {

    public static int specialArray(int[] nums) {

        int res = -1;
        for(int i = 1;i <= nums.length;i ++){
            int ans = 0;
            for(int j = 0;j < nums.length;j ++){
                if(nums[j] >= i)
                    ans ++;
            }
            if(ans == i){
                res = ans;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,7,7,0};
        System.out.println (specialArray (nums));
    }
}
