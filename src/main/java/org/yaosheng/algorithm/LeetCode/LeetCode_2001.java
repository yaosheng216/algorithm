package org.yaosheng.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaosheng on 2023/3/15.
 */
public class LeetCode_2001 {

    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double, Integer> map = new HashMap<> ();
        long count = 0;
        for(int[] rect: rectangles){
            double ratio = (double) rect[0] / rect[1];
            if(map.containsKey(ratio)){
                int freq = map.get(ratio);
                count += freq;
                map.put(ratio, freq + 1);
            } else {
                map.put(ratio, 1);
            }
        }
        return count;
    }
}
