package org.yaosheng.algorithm.BubbleSort;

import org.yaosheng.algorithm.algorithm.ArrayGenerator;
import org.yaosheng.algorithm.algorithm.SortingHelper;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/7/22.
 * 冒泡排序
 */
public class BubbleSort {

    private BubbleSort(){}

    public static <E extends Comparable<E>> void sort(E[] data){

        for(int i = 0;i + 1 < data.length;i ++){
            // arr[n - i,n)已排好序
            // 通过冒泡在arr[n - i - 1]位置放上合适的元素
            for(int j = 0;j < data.length - i - 1;j ++){
                if(data[j].compareTo (data[j + 1]) > 0){
                    swap(data,j,j + 1);
                }
            }
        }
    }

    // 优化过的冒泡排序，时间复杂度为：O(n)
    public static <E extends Comparable<E>> void sort2(E[] data){

        for(int i = 0;i + 1 < data.length;i ++){
            // arr[n - i,n)已排好序
            // 通过冒泡在arr[n - i - 1]位置放上合适的元素
            boolean isSwapped = false;
            for(int j = 0;j < data.length - i - 1;j ++){
                if(data[j].compareTo (data[j + 1]) > 0){
                    swap(data,j,j + 1);
                    isSwapped = true;
                }
            }
            if(!isSwapped)
                break;
        }
    }

    private static <E> void swap(E[] arr,int i,int j){

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int n = 1000000;
        Integer[] arr = ArrayGenerator.generateRandomArray (n,n);
        Integer[] arr2 = Arrays.copyOf (arr, arr.length);

        System.out.println ("Random Array");
        SortingHelper.sortTest ("BubbleSort",arr);
        SortingHelper.sortTest ("BubbleSort2",arr2);

        arr = ArrayGenerator.generateOrderedArray (n);
        arr2 = Arrays.copyOf (arr,arr.length);

        System.out.println ("Order Array");
        SortingHelper.sortTest ("BubbleSort",arr);
        SortingHelper.sortTest ("BubbleSort2",arr2);
    }
}
