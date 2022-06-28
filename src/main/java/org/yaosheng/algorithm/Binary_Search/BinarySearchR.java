package org.yaosheng.algorithm.Binary_Search;

/**
 * Created by yaosheng on 2022/6/28.
 * 非递归实现二分查找
 */
public class BinarySearchR {

    private BinarySearchR(){

    }

    public static <E extends Comparable<E>> int search(E[] data,E target){

        int l = 0,r = data.length - 1;
        // 在data[l,r]的范围中查找target
        while(l <= r){
            int mid = l + (r - l) / 2;

            if(data[mid].compareTo (target) == 0)
                return mid;
            if(data[mid].compareTo (target) < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }
}
