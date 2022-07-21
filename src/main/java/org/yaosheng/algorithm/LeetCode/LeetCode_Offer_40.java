package org.yaosheng.algorithm.LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by yaosheng on 2022/7/21.
 */
public class LeetCode_Offer_40 {

    public int[] getLeastNumbers(int[] arr, int k) {

        // 优先队列默认为最小堆，添加 Collections.reverseOrder() 设置为最大堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < k; i ++)
            pq.add(arr[i]);

        for(int i = k; i < arr.length; i ++)
            if(!pq.isEmpty() && arr[i] < pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }

        int[] res = new int[k];
        for(int i = 0; i < k; i ++)
            res[i] = pq.poll();

        return res;
    }
}
