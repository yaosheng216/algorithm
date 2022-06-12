package org.yaosheng.algorithm.algorithm;

import java.util.Random;

/**
 * Created by yaosheng on 2022/6/8.
 */
public class ArrayGenerator {

    private ArrayGenerator(){

    }

    public static Integer[] generateOrderArray(int n){

        Integer[] arr = new Integer[n];
        for(int i = 0;i < n;i ++){
            arr[i] = i;
        }
        return arr;
    }

    // 生成一个长度为n的随机数组，长度为[0,bound)
    public static Integer[] generateRandomArray(int n,int bound){

        Integer[] arr = new Integer[n];
        Random rnd = new Random ();
        for(int i = 0;i < n;i ++){
            arr[i] = rnd.nextInt (bound);
        }
        return arr;
    }
}
