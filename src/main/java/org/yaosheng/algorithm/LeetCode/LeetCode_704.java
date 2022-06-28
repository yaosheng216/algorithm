package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/6/28.
 */
public class LeetCode_704 {

    public int search(int[] nums,int target){
        return search (nums,0,nums.length - 1,target);
    }

    private int search(int[] data,int l,int r,int target){

        if(l > r)
            return -1;

        int mid = l + (r - l) / 2;
        if(data[mid] == target)
            return mid;
        if(data[mid] < target)
            return search (data,mid + 1,r,target);
        return search (data,l,mid - 1,target);
    }
}
