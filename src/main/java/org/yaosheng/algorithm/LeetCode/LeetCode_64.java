package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/8/7.
 */
public class LeetCode_64 {

    public static int minPathSum(int[][] grid){

        if(grid.length == 0)
            return 0;

        int x = 0,y = 0;
        int res = grid[x][y];

        while(x <= grid.length && y <= grid[grid.length - 1].length){
           int right = res + grid[x][y + 1];
           int next = res + grid[x + 1][y];
           if(y == grid[1].length - 1){
               x ++;
               res += grid[x][y];
               continue;
           }
           if(right < next){
               y ++;
           }else{
               x ++;
           }
           res = Math.min (right,next);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println (minPathSum (nums));
    }
}
