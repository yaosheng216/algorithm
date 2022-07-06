package org.yaosheng.algorithm.Binary_Search;

/**
 * Created by yaosheng on 2022/6/28.
 * 使用递归实现二分查找
 */
public class BinarySearch {

    private BinarySearch(){

    }

    public static <E extends Comparable<E>> int search(E[] data,E target){
        return search (data,0, data.length - 1,target);
    }

    private static <E extends Comparable<E>> int search(E[] data,int l,int r,E target){

        if(l > r)
            return -1;

        int mid = l + (r - l) / 2;
        if(data[mid].compareTo (target) == 0)
            return mid;
        if(data[mid].compareTo (target) < 0)
            return search (data,mid + 1,r,target);
        return search (data,l,mid - 1,target);
    }

    // target的最小值索引
    public static <E extends Comparable<E>> int upper(E[] data,E target){

        int l = 0,r = data.length;
        // 在data[l,r]中寻解
        while(l < r){
            int mid = l + (r - l) / 2;
            if(data[mid].compareTo (target) <= 0)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public static void main(String[] args) {

        Integer[] arr = {1,1,3,3,5,5};
        for(int i = 0;i <= 6;i ++)
            System.out.println (BinarySearch.upper (arr,i));
    }
}
