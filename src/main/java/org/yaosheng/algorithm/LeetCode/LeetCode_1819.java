package org.yaosheng.algorithm.LeetCode;

import java.util.Arrays;

/**
 * Created by yaosheng on 2023/1/14.
 */
public class LeetCode_1819 {

    public int countDifferentSubsequenceGCDs(int[] nums) {

        Arrays.sort(nums);
        int[] helper = new int[nums[nums.length - 1] + 1];

        for(int i = 0; i < nums.length; i ++){
            for(int j = 1; j * j <= nums[i]; j ++){
                if(nums[i] % j == 0){
                    if(helper[j] == 0){
                        helper[j] = nums[i];
                    }else{
                        helper[j] = gcd(helper[j],nums[i]);
                    }
                    int k = nums[i] / j;
                    if(k != j){
                        if(helper[k] == 0){
                            helper[k] = nums[i];
                        }else{
                            helper[k] = gcd(helper[k],nums[i]);
                        }
                    }
                }
            }
        }
        int res = 0;
        for(int i = 1; i < nums[nums.length - 1] + 1; i ++){
            if(helper[i] == i){
                res ++;
            }
        }
        return res;
    }

    public int gcd(int a,int b){
        int c;
        while(b != 0){
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
