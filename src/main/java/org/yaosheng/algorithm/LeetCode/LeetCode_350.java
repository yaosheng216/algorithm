package org.yaosheng.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by yaosheng on 2022/7/13.
 */
public class LeetCode_350 {

    public int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer,Integer> map = new TreeMap<> ();
        for(int num : nums1){
            if(!map.containsKey (num))
                map.put (num,1);
            else
                map.put(num,map.get (num) + 1);
        }

        ArrayList<Integer> list = new ArrayList<> ();
        for(int num : nums2){
            if(map.containsKey (num)){
                list.add (num);
                map.put(num,map.get (num) - 1);
                if(map.get (num) == 0)
                    map.remove (num);
            }
        }

        int[] res = new int[list.size ()];
        for(int i = 0;i < list.size ();i ++)
            res[i] = list.get (i);

        return res;
    }
}
