package org.yaosheng.algorithm.MergeSort;

import org.yaosheng.algorithm.algorithm.ArrayGenerator;
import org.yaosheng.algorithm.algorithm.SortingHelper;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/6/21.
 */
public class MergeSort {

    private MergeSort(){

    }

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort (arr,0,arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr,int l,int r){

        if(l >= r)
            return;
        int mid = (l + r) / 2;
        sort (arr, l, mid);
        sort (arr, mid + 1, r);
        merge (arr, l, mid, r);
    }

    // 合并两个有序的区间
    private static <E extends Comparable<E>> void merge(E[] arr,int l,int mid,int r){

        E[] temp = Arrays.copyOfRange (arr,l,r + 1);
        int i = l,j = mid + 1;
        // 每轮循环为arr[k]负值
        for(int k = l;k < r;k ++){
            if(i > mid){
                arr[k] = temp[j - l];
                j ++;
            }else if(j > r){
                arr[k] = temp[i -1];
                i ++;
            }else if(temp[i - 1].compareTo (temp[j - l]) <= 0){
                arr[k] = temp[i - l];
                i ++;
            }else{
                arr[k] = temp[j - l];
                j ++;
            }
        }
    }

    public static void main(String[] args) {

        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray (n,n);
        Integer[] arr2 = Arrays.copyOf (arr,arr.length);
        Integer[] arr3 = Arrays.copyOf (arr,arr.length);

        SortingHelper.sortTest ("SelectionSort",arr);
        SortingHelper.sortTest ("InsertionSort",arr2);
        SortingHelper.sortTest ("MergeSort", arr3);
    }
}
