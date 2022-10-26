package org.yaosheng.algorithm.LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yaosheng on 2022/10/26.
 */
public class LeetCode_862 {

    public static int shortestSubarray(int[] nums, int k) {

        Deque<int[]> q = new ArrayDeque<> ();
        int sum = 0 , n = nums.length + 1;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] < 0){
                int m = nums[i] , j = i;
                while(!q.isEmpty() && m < 0){
                    int[] p = q.pollLast();
                    m += p[0];
                    j = p[1];
                }
                if(m > 0)
                    q.add(new int[]{m,j});
                sum = Math.max (nums[i] + sum, 0);
            } else{
                sum += nums[i];
                q.add(new int[]{nums[i],i});
            }
            if(sum >= k){
                int m = 0;
                while(sum >= k){
                    int[] p = q.pollFirst();
                    m = p[1];
                    sum -= p[0];
                }
                n = Math.min(n,q.isEmpty() ? 1 : q.peekLast()[1] - m + 1);
            }
        }
        return n > nums.length ? -1 : n;
    }

    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println (shortestSubarray (arr,4));
    }
}
