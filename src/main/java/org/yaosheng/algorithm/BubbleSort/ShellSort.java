package org.yaosheng.algorithm.BubbleSort;

import org.yaosheng.algorithm.Algorithm.ArrayGenerator;
import org.yaosheng.algorithm.Algorithm.SortingHelper;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/7/23.
 * 希尔排序
 */
public class ShellSort {

    private ShellSort(){}

    public static <E extends Comparable<E>> void sort(E[] data){

        int h = data.length / 2;
        while(h >= 1){
            // 对data[h,n)进行插入排序
            for(int i = h;i < data.length;i ++){
                E t = data[i];
                int j;
                for(j = i;j - h >= 0 && t.compareTo (data[j - h]) < 0;j -= h){
                    data[j] = data[j - h];
                }
                data[j] = t;
            }
            h /= 2;
        }
    }

    // 步长序列实现希尔算法
    public static <E extends Comparable<E>> void sort2(E[] data){

        int h = 1;
        while(h < data.length)
            h = h * 3 + 1;

        while(h >= 1){
            // 对data[h,n)进行插入排序
            for(int i = h;i < data.length;i ++){
                E t = data[i];
                int j;
                for(j = i;j - h >= 0 && t.compareTo (data[j - h]) < 0;j -= h){
                    data[j] = data[j - h];
                }
                data[j] = t;
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {

        int n = 10000000;
        Integer[] arr = ArrayGenerator.generateRandomArray (n,n);
        Integer[] arr2 = Arrays.copyOf (arr,arr.length);

        SortingHelper.sortTest ("ShellSort",arr);
        SortingHelper.sortTest ("ShellSort2",arr2);
    }
}
