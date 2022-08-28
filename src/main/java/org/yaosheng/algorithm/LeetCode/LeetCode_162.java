package org.yaosheng.algorithm.LeetCode;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/8/27.
 */
public class LeetCode_162 {

    public static int findPeakElement(int[] nums){
        return find (nums,0, nums.length - 1);
    }

    private static int find(int[] nums,int l,int r){

        if((r - l) < 2)
            return -1;

        int mid = l + (r - l) / 2;
        if(nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]){
            return mid;
        }
        find(nums,l,mid);
        find(nums,mid + 1,r);

        return Math.max (find(nums,l,mid),find(nums,mid + 1,r));
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println (findPeakElement (arr));
    }
}
