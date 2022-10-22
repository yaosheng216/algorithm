package org.yaosheng.algorithm.LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yaosheng on 2022/10/22.
 */
public class LeetCode_56 {

    public static int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        List<int[]> list = new LinkedList<> (Arrays.asList(intervals));
        int i = 0;
        int j = 1;

        while(i <list.size() && j < list.size()){
            final int[] ii = list.get(i);
            final int[] jj = list.get(j);
            if(ii[1] >= jj[0]){
                ii[1] = Math.max(ii[1], jj[1]);
                list.remove(j);
            }else{
                i ++;
                j ++;
            }
        }
        return list.toArray(new int[0][0]);
    }
}
