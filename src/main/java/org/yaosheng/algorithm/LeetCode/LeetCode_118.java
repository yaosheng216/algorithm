package org.yaosheng.algorithm.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yaosheng on 2022/8/30.
 */
public class LeetCode_118 {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new LinkedList<> ();
        if(numRows < 1){
            return lists;
        }

        List<Integer> first = new LinkedList<>();
        first.add(1);
        lists.add(first);
        int[][] arr = new int[numRows][numRows];

        for (int i = 0; i < numRows; i ++) {
            arr[i][0] = 1;
        }

        for (int i = 1; i < numRows; i ++) {
            List<Integer> list = new LinkedList<> ();
            list.add(1);
            for (int j = 1; j <= i; j ++) {
                arr[i][j] = arr[i -1 ][j] + arr[i - 1][j - 1];
                list.add(arr[i][j]);
            }
            lists.add(list);
        }
        return lists;
    }
}
