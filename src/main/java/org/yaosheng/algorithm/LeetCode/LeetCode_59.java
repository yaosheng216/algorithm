package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/10/26.
 */
public class LeetCode_59 {

    public static int[][] generateMatrix(int n) {

        int[][] arr = new int[n][n];
        int c = 1, j = 0;

        while (c <= n * n) {
            for (int i = j;i < n - j;i ++)
                arr[j][i] = c ++;
            for (int i = j + 1;i < n - j;i ++)
                arr[i][n - j - 1] = c ++;
            for (int i = n - j - 2;i >= j;i --)
                arr[n - j - 1][i] = c ++;
            for (int i = n - j - 2;i > j;i --)
                arr[i][j] = c ++;
            j ++;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println (generateMatrix (3));
    }
}
