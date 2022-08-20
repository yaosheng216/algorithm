package org.yaosheng.algorithm.LeetCode;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/8/20.
 * 使用SQRT分解实现
 */
public class LeetCode_303_3 {

    private int[] data,blocks;
    private int N;   // 元素总数
    private int B;   // 每组的元素个数
    private int Bn;  // 组数

    public LeetCode_303_3(int[] nums){

        N = nums.length;
        if(N == 0)
            return;

        B = (int)Math.sqrt (N);
        Bn = N / B + (N % B > 0 ? 1 : 0);

        data = Arrays.copyOf (nums,N);
        blocks = new int[Bn];
        for(int i = 0;i < N;i ++)
            blocks[i / B] += nums[i];
    }

    public int sumRange(int i,int j){

        if(i < 0 || i >= N || j < 0 || j >= N || i > j)
            return 0;

        int bStart = i / B,bend = j / B;

        int res = 0;
        if(bStart == bend){
            for(int k = j;k <= j;k ++)
                res += data[k];
            return res;
        }

        for(int k = i;k < (bStart + 1) * B;k ++)
            res += data[k];
        for(int b = bStart + 1;b < bend;b ++)
            res += blocks[b];
        for(int k = bend * B;k <= j;k ++)
            res += data[k];

        return res;
    }
}
