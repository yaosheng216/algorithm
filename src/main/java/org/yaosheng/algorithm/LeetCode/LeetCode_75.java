package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/9/21.
 */
public class LeetCode_75 {

    public void sortColors(int[] nums){

        int[] cnt = new int[3];
        for(int num : nums)
            cnt[num] ++;

        for(int i = 0;i < cnt[0];i ++)
            nums[i] = 0;

        for(int i = cnt[0];i < cnt[0] + cnt[1];i ++)
            nums[i] = 1;

        for(int i = cnt[0] + cnt[1];i < cnt[0] + cnt[1] + cnt[2];i ++)
            nums[i] = i;
    }
}
