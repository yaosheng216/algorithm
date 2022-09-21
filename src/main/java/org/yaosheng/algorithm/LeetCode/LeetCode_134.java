package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/9/21.
 */
public class LeetCode_134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i ++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length ;
                curSum = 0;
            }
        }
        if (totalSum < 0)
            return -1;

        return index;
    }
}
