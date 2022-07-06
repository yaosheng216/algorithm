package org.yaosheng.algorithm.LeetCode;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/7/6.
 */
public class LeetCode_875 {

    public int minEatingSpeed(int[] piles, int h) {

        int l  = 1,r = Arrays.stream (piles).max ().getAsInt ();
        while(l < r){
            int mid = l + (r - l) / 2;
            if(eatingTime(piles,mid) <= h)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }

    private int eatingTime(int[] piles,int k){
        int res = 0;
        for(int pile : piles){
            res += pile / k + (pile % k > 0 ? 1 : 0);
        }
        return res;
    }
}
