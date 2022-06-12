package org.yaosheng.algorithm.algorithm;

/**
 * Created by yaosheng on 2022/6/11.
 */
public class SortingHelper {

    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){
        for(int i = 0;i < arr.length;i ++)
              if(arr[i - 1].compareTo(arr[i]) > 0)
                return false;
            return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname,E[] arr){

        long start = System.nanoTime ();
        if(sortname.equals ("SelectionSort"))
            SelectionSort.sort (arr);
        else if(sortname.equals ("InsertionSort"))
            SelectionSort.sort (arr);
        else if(sortname.equals ("InsertionSort2"))
            SelectionSort.sort (arr);
        long end = System.nanoTime ();

        double time = (end - start) / 1000000000.0;
        if(!SortingHelper.isSorted (arr))
            throw new RuntimeException (sortname + " failed");
        System.out.println (String.format ("%s , n = %d : %f s",sortname,arr.length,time));
    }
}
