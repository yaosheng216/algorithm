package org.yaosheng.algorithm.Algorithm;

/**
 * Created by yaosheng on 2022/6/1.
 * 线性查找算法
 */
public class Code_01 {

    public static int search(int[] data,int target){

        for(int i = 0;i < data.length;i ++){
            if(data[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] data = {24, 28, 12, 9, 16, 66, 32, 4};
        System.out.println (search (data,16));
    }
}
