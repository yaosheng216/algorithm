package org.yaosheng.algorithm.LeetCode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by yaosheng on 2022/8/14.
 */
public class LeetCode_1422 {

    public static int maxScore(String s){

        if(s.length () == 0)
            return 0;

        char[] c = s.toCharArray ();
        Queue<String> q1 = new PriorityQueue<> ();
        Queue<String> q2 = new PriorityQueue<> ();

        for(int i  = 0;i < c.length;i ++){
            if(c[i] == '0')
                q1.add ("0");
            else
                q2.add ("1");
        }

        int k = q1.size () + q2.size ();
        if(q1.size () == 0 || q2.size () == 0)
            k --;

        return k;
    }

    public static void main(String[] args) {
        System.out.println (maxScore ("011101"));
    }
}
