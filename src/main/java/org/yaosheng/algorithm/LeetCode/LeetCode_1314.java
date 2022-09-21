package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/9/12.
 */
public class LeetCode_1314 {

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int y = mat.length, x = mat[0].length;
        // 计算
        for (int i = 0; i < y; i ++) {
            for (int j = 1; j<x; j++) {
                mat[i][j] = mat[i][j - 1] + mat[i][j];
            }
        }
        for (int j = 0; j < x; j ++) {
            for (int i=1; i < y; i ++) {
                mat[i][j] = mat[i - 1][j] + mat[i][j];
            }
        }

        int[][] res = new int[y][x];
        for (int i = 0; i < y; i ++) {
            for (int j = 0; j < x; j ++) {
                setValue(mat, res, i, j, k);
            }
        }
        return res;
    }

    public void setValue(int[][] mat, int[][] res, int y, int x, int k) {
        // 右下角坐标
        int y2 = Math.min(res.length - 1, y + k), x2 = Math.min(res[0].length - 1, x + k);
        // 左上角坐标
        int y1 = Math.max(0, y - k), x1 = Math.max(0, x - k);

        // 合计
        int sum = mat[y2][x2];
        // left&top
        int left = x1 == 0 ? 0 : mat[y2][x1 - 1];
        int top  = y1 == 0 ? 0 : mat[y1 - 1][x2];
        // repeat
        int repeat = (x1 == 0 || y1 == 0) ? 0 : mat[y1 - 1][x1 - 1];
        res[y][x] = sum - left - top + repeat;
    }
}
