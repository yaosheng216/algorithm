package org.yaosheng.algorithm.Heap;

import java.util.Random;

/**
 * Created by yaosheng on 2022/7/19.
 */
public class Main {

    private static double testHeap(Integer[] testData,boolean isHeapify){

        long start = System.nanoTime ();
        MaxHeap<Integer> maxHeap = new MaxHeap<> ();

        if(isHeapify)
            maxHeap = new MaxHeap<> (testData);
        else{
            maxHeap = new MaxHeap<> ();
            for(int num : testData)
                maxHeap.add (num);
        }

        int[] arr = new int[testData.length];
        for(int i = 0 ; i < testData.length ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < testData.length ; i ++)
            if(arr[i - 1] < arr[i])
                throw new IllegalArgumentException("Error");

        long end = System.nanoTime ();
        return (end - start) / 1000000000.0;

    }
    public static void main(String[] args) {

        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for(int i = 0 ; i < n ; i ++)
            testData[i] = random.nextInt(Integer.MAX_VALUE);

        double time1 = testHeap (testData,false);
        System.out.println ("Without heapify: " + time1 + " s");

        double time2 = testHeap (testData,true);
        System.out.println ("Without heapify: " + time2 + " s");
    }
}
