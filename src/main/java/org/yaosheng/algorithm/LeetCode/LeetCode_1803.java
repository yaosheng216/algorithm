package org.yaosheng.algorithm.LeetCode;

import java.util.Arrays;

/**
 * Created by yaosheng on 2023/1/5.
 */
public class LeetCode_1803 {

    public static int countPairs(int[] nums,int low,int high){

        int res = 0;
        Arrays.sort (nums);
        for(int i = 0;i < nums.length - 1;i ++){
            for(int j = i + 1;j < nums.length;j ++){
                if((nums[i] ^ nums[j]) >= low && (nums[i] ^ nums[j]) <= high){
                    res ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {7881,760,709,2937,1245,720,5187,6361,3793,141,7238};
        System.out.println (countPairs (arr,1492,3832));
    }
}
