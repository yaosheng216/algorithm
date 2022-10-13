package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/10/13.
 */
public class LeetCode_769 {

    public static int maxChunksToSorted(int[] arr) {

        int res = 0;
        int vSum = 0;
        int iSum = 0;

        for(int i = 0; i < arr.length; i++){
            vSum += arr[i];
            iSum += i;
            if(vSum == iSum)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,3};
        System.out.println (maxChunksToSorted (arr));
    }
}
