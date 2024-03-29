package org.yaosheng.algorithm.Algorithm;

/**
 * Created by yaosheng on 2022/6/11.
 * 插入排序
 */
public class InsertionSort {

    private InsertionSort(){}

    public static <E extends Comparable<E>> void sort(E[] arr){

        for(int i = 0; i < arr.length; i ++){
            // 将arr[i]插入到合适的位置
            E t = arr[i];
            int j;
            for(j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j --){
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r){

        for(int i = l; i <= r; i ++){

            // 将arr[i]插入到合适的位置
            E t = arr[i];
            int j;
            for(j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j --){
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }
}
