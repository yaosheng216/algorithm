package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/8/7.
 */
public class LeetCode_64 {

    public static int minPathSum(int[][] grid){

        int width = grid[0].length, high = grid.length;
        if (high == 0 || width == 0)
            return 0;

        // 初始化
        for (int i = 1; i < high; i ++)
            grid[i][0] += grid[i - 1][0];

        for (int i = 1; i < width; i ++)
            grid[0][i] += grid[0][i - 1];

        for (int i = 1; i < high; i ++)
            for (int j = 1; j < width; j++)
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);

        return grid[high - 1][width - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println (minPathSum (nums));
    }
}
