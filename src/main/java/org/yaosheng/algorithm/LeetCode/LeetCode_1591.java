package org.yaosheng.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yaosheng on 2023/1/8.
 */
public class LeetCode_1591 {

    public static boolean isPrintable(int[][] targetGrid) {

        List[] adjList;
        int[] top=new int[61];
        int[] bottom=new int[61];
        int[] left=new int[61];
        int[] right=new int[61];
        int color;

        for(int i = 1;i <= 60;i ++){
            top[i] = 61;
            bottom[i] = 0;
            left[i] = 61;
            right[i] = 0;
        }

        // 遍历图中的像素，求出每种颜色的矩形范围
        for(int r = 0;r < targetGrid.length;r ++){
            for(int c = 0;c < targetGrid[0].length;c ++){
                color = targetGrid[r][c];
                top[color] = Math.min(top[color], r);
                bottom[color] = Math.max(bottom[color], r);
                left[color] = Math.min(left[color], c);
                right[color] = Math.max(right[color], c);
            }
        }

        // 建有向图
        adjList = new List[61]; // 用邻接链表的方式表示有向图
        boolean[][] haveEdge = new boolean[61][61]; // 判断是否已经有边，避免重复添加
        int[] indegree = new int[61];
        for(int i = 1;i <= 60;i ++){
            adjList[i] = new ArrayList<Integer> ();
        }
        for(int r = 0;r < targetGrid.length;r ++){
            for(int c = 0;c < targetGrid[0].length;c ++){
                color = targetGrid[r][c];
                for(int cl = 1;cl <= 60;cl ++){
                    if(r >= top[cl] && r <= bottom[cl] && c >= left[cl] && c <= right[cl] && color != cl && haveEdge[color][cl] == false){
                        haveEdge[color][cl] = true;
                        indegree[cl] ++;
                        adjList[color].add(cl);
                    }
                }
            }
        }

        // 进行拓扑排序，如果最后存在入度不为0的颜色，则不能打印
        int count = 0;
        Queue<Integer> queue = new LinkedList<> ();
        for(int i = 1;i <= 60;i ++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            color = queue.poll();
            for(int i = 0;i < adjList[color].size();i ++){
                int c = (Integer)adjList[color].get(i);
                indegree[c] --;
                if(indegree[c] == 0){
                    queue.offer(c);
                }
            }
        }
        for(int i = 1;i <= 60;i ++){
            if(indegree[i]>0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1},{1,2,2,1},{1,2,2,1},{1,1,1,1}};
        System.out.println (isPrintable (grid));
    }
}
