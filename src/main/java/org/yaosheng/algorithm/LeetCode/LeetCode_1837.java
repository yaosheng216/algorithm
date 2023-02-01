package org.yaosheng.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaosheng on 2023/2/1.
 */
public class LeetCode_1837 {

    public static int sumBase(int n,int k){
        List<Integer> list = new ArrayList<Integer>();
        while(n >= k){
            int num = n / k;
            list.add(n % k);
            n = num;
        }
        list.add(n);
        int sum = 0;
        for(Integer num : list) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println (sumBase (34,6));
    }
}
