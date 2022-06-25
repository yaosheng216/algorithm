package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/6/25.
 * 递归实现
 */
public class LeetCode_Offer_51 {

    private int res;

    public int reversePairs(int[] nums){

        int[] temp = new int[nums.length];
        res = 0;
        sort (nums,0,nums.length - 1,temp);
        return res;
    }

    public void sort(int[] arr,int l,int r,int[] temp){

        if(l >= r)
            return;
        int mid = l + (r - l) / 2;
        sort (arr,l,mid,temp);
        sort (arr,mid + 1,r,temp);

        if(arr[mid] > arr[mid + 1])
            merge (arr,l,mid,r,temp);
    }

    private void merge(int[] arr,int l,int mid,int r,int[] temp){

        System.arraycopy (arr,l,temp,l,r - l + 1);
        int i = l,j = mid + 1;

        // 每轮循环为arr[k]负值
        for(int k = l;k <= r;k ++){
            if(i > mid){
                arr[k] = temp[j];
                j ++;
            }else if(j > r){
                arr[k] = temp[i];
                i ++;
            }else if(temp[i] <= temp[j]){
                arr[k] = temp[i];
                i ++;
            }else{
                res += mid - i + 1;
                arr[k] = temp[j];
                j ++;
            }
        }
    }
}
