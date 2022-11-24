package org.yaosheng.algorithm.LeetCode;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/11/24.
 */
public class LeetCode_1386 {

    int left = 0b0111100000;
    int right = 0b0000011110;
    int middle = 0b0001111000;

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        int res = 0, row;
        Arrays.sort(reservedSeats, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 1, x = 0; i <= n;i ++) {
            if (x == reservedSeats.length) {
                res += 2 * (n - i + 1);
                break;
            } else if (reservedSeats[x][0] != i) {
                res += 2;
            } else {
                row = 0;
                while (x < reservedSeats.length && reservedSeats[x][0] == i) {
                    row |= (1 << (10 - reservedSeats[x++][1]));
                }
                if ((row & left) == 0) {
                    res ++;
                }
                if ((row & right) == 0) {
                    res ++;
                }
                if ((row & left) != 0 && (row & right) != 0 && (row & middle) == 0) {
                    res ++;
                }
            }
        }
        return res;
    }
}
