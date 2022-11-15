package org.yaosheng.algorithm.LeetCode;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/11/15.
 */
public class LeetCode_1710 {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;
        Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        for (int[] boxType : boxTypes) {
            if (truckSize <= 0)
                break;
            int a = boxType[0], b = boxType[1], c = Math.min(truckSize, a);
            ans += c * b;
            truckSize -= c;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2,1},{2,2},{1,3}};
        System.out.println (maximumUnits (arr,2));
    }
}
