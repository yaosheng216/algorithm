package org.yaosheng.algorithm.LeetCodeGames;

/**
 * Created by yaosheng on 2022/10/23.
 */
public class LCGames_6224 {

    public static int subarrayGCD(int[] nums, int k) {

        int res = 0;
        for(int i = 0;i < nums.length;i ++){
            if(nums[i] == k){
                res ++;
            }
            for(int j = i + 1;j < nums.length;j ++){
                if(nums[i] % k == 0 && nums[j] % k == 0 ){
                    res ++;
                }else{
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,4,1,2};
        System.out.println (subarrayGCD (arr,1));
    }
}
