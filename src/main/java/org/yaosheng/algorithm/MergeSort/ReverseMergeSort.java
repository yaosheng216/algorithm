package org.yaosheng.algorithm.MergeSort;

import org.yaosheng.algorithm.algorithm.ArrayGenerator;
import org.yaosheng.algorithm.algorithm.SortingHelper;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/6/23.
 * 自底向上归并排序
 */
public class ReverseMergeSort {

    public static <E extends Comparable<E>> void sortBU(E[] arr){

        E[] temp = Arrays.copyOf (arr,arr.length);
        int n = arr.length;
        for(int sz = 1;sz < n; sz += sz){
            // 遍历合并的两个区间的起始位置i
            // 合并[i,i + sz - 1]和[i + sz,Math.min(i + sz + sz - 1,n - 1)]
            for(int i = 0;i + sz < n;i += sz + sz){
                if(arr[i + sz - 1].compareTo (arr[i + sz]) > 0)
                    merge (arr,i,i + sz,Math.min(i + sz + sz - 1,n - 1),temp);
            }
        }
    }

    private static <E extends Comparable<E>> void merge(E[] arr,int l,int mid,int r,E[] temp){

        System.arraycopy(arr,l,temp,l,r - l + 1);
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

        int n = 5000000;
        Integer[] arr = ArrayGenerator.generateRandomArray (n,n);

        SortingHelper.sortTest ("MergeSortBU", arr);
    }
}
