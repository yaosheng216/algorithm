package org.yaosheng.algorithm.MergeSort;

import org.yaosheng.algorithm.algorithm.ArrayGenerator;
import org.yaosheng.algorithm.algorithm.SortingHelper;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/6/21.
 * 归并排序
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

    public static <E extends Comparable<E>> void sort2(E[] arr){
        sort2 (arr,0,arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2(E[] arr,int l,int r){

        if(l >= r)
            return;

        int mid = (l + r) / 2;
        sort2 (arr, l, mid);
        sort2 (arr, mid + 1, r);
        if(arr[mid].compareTo (arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    // 合并两个有序的区间
    private static <E extends Comparable<E>> void merge(E[] arr,int l,int mid,int r){

        // 将数组进行拷贝
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

    public static <E extends Comparable<E>> void sort3(E[] arr){
        E[] temp = Arrays.copyOf(arr,arr.length);
        sort3(arr,0,arr.length - 1,temp);
    }

    private static <E extends Comparable<E>> void sort3(E[] arr,int l,int r,E[] temp){

        if(l >= r){
            return;
        }

        int mid = (l + r) / 2;
        sort3 (arr, l, mid, temp);
        sort3 (arr, mid + 1, r, temp);
        if(arr[mid].compareTo (arr[mid + 1]) > 0)
            merge2 (arr, l, mid, r,temp);
    }

    private static <E extends Comparable<E>> void merge2(E[] arr,int l,int mid,int r,E[] temp){

        System.arraycopy (arr,l,temp,l,r - l + 1);
        int i = l,j = mid + 1;
        // 每轮循环为arr[k]负值
        for(int k = l;k < r;k ++){
            if(i > mid){
                arr[k] = temp[j];
                j ++;
            }else if(j > r){
                arr[k] = temp[i];
                i ++;
            }else if(temp[i].compareTo (temp[j]) <= 0){
                arr[k] = temp[i];
                i ++;
            }else{
                arr[k] = temp[j];
                j ++;
            }
        }
    }

    public static void main(String[] args) {

        int n = 100000;
        Integer[] arr = ArrayGenerator.generateRandomArray (n,n);
        Integer[] arr2 = Arrays.copyOf (arr,arr.length);
        Integer[] arr3 = Arrays.copyOf (arr,arr.length);

        SortingHelper.sortTest ("MergeSort", arr);
        SortingHelper.sortTest ("MergeSort2",arr2);
        SortingHelper.sortTest ("MergeSort3",arr3);
    }
}
