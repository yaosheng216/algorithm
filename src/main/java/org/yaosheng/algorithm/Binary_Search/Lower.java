package org.yaosheng.algorithm.Binary_Search;

/**
 * Created by yaosheng on 2022/7/6.
 */
public class Lower {

    public static <E extends Comparable<E>> int lower(E[] data,E target){

        int l = -1,r = data.length;
        // 在data[l,r]中寻解
        while(l < r){
            int mid = l + (r - l + 1) / 2;
            if(data[mid].compareTo (target) < 0)
                l = mid;
            else
                r = mid - 1;
        }
        return l;
    }

    public static void main(String[] args) {

        Integer[] arr = {1,1,3,3,5,5};
        for(int i = 0;i <= 6;i ++)
            System.out.println (Lower.lower (arr,i));
    }
}
