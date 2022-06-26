package org.yaosheng.algorithm.QuickSort;

import java.util.Random;

/**
 * Created by yaosheng on 2022/6/26.
 * 双路快速排序
 */
public class DoubleWayQuickSort {

    private DoubleWayQuickSort(){

    }

    public static <E extends Comparable<E>> void sort2ways(E[] arr){
        Random rnd = new Random ();
        sort2ways (arr,0,arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort2ways(E[] arr,int l,int r){

        if(l >= r)
            return;
        int p = partition (arr,l,r);
        sort2ways (arr,l,p - 1);
        sort2ways (arr,p + 1,r);
    }

    private static <E extends Comparable<E>> int partition(E[] arr,int l,int r){

        // 生成[l,r]之间的随机索引
        int p = l + (new Random ()).nextInt (r - l + 1);
        swap (arr,l,p);

        // arr[l + 1...i - 1] <= v; arr[j + 1...r] >= v
        int i = l + 1,j = r;
        while(true){
            while(i <= j && arr[i].compareTo (arr[l]) < 0)
                i ++;
            while(j >= i && arr[j].compareTo (arr[l]) > 0)
                j --;
            if(i >= j)
                break;

            swap (arr,i,j);
            i ++;
            j --;
        }
        swap (arr,l,j);
        return j;
    }

    private static <E> void swap(E[] arr,int i,int j){

        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
