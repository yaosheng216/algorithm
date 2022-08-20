package org.yaosheng.algorithm.LeetCodeGames;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/8/20.
 */
public class LCGames_6156 {

    public static int minimumRecolors(String blocks, int k){

        char[] c = blocks.toCharArray ();
        int res = Integer.MAX_VALUE;

        for(int i = 0;i + k <= c.length;i ++){
            char[] arr = Arrays.copyOfRange (c,i,i + k);
            int num = 0;
            for(int j = 0;j < arr.length;j ++){
                if(arr[j] == 'W'){
                    num ++;
                }
            }
            res = Math.min (res,num);
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "BWWWBB";
        System.out.println (minimumRecolors (s,6));
    }
}
