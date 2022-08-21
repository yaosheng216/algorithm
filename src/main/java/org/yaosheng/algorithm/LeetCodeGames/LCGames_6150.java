package org.yaosheng.algorithm.LeetCodeGames;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/8/14.
 */
public class LCGames_6150 {

    public static String smallestNumber(String pattern){

        char[] c = pattern.toCharArray ();
        int[] arr = new int[pattern.length () + 1];
        int k = 1,j = 9;

        for(int i = 0;i < c.length;i ++){
            if(c[i] == 'I'){
                arr[i] = k ++;
            }
        }
        for(int i = 0;i < c.length;i ++){
            if(c[i] == 'D'){
                if(i != 0){
                    if(c[i - 1] == 'I' && c[i + 1] == 'I' ){
                        int num = arr[i + 1];
                        arr[i] = num + 1;
                    }else {
                        arr[i] = j --;
                    }
                }
            }
        }
        return new String (c);
    }

    public static void main(String[] args) {
        System.out.println (smallestNumber ("IIIDIDDD"));
    }
}
