package org.yaosheng.algorithm.LeetCode;

import java.util.*;

/**
 * Created by yaosheng on 2022/8/7.
 */
public class LeetCode_636 {

    public static int[] exclusiveTime(int n, List<String> logs){

        Map<Integer,String> maps = new LinkedHashMap<> ();
        int[] res = new int[n];
        int k = 0;

        for(String s : logs){

            String i = s.substring (0,s.indexOf (":"));
            int thread = Integer.parseInt (i);

            int index = s.indexOf (":");
            index = s.indexOf (":",index + 1);
            String t = s.substring (index + 1);
            int time = Integer.parseInt (t);

            String status = s.substring (s.indexOf (":") + 1,s.indexOf (":",2));

            if(thread == k && maps.containsKey (thread)){
                if(maps.get (maps.size ()) != status){
                    res[thread] = time - res[thread] + 1;
                    k = thread;
                }else{
                    res[thread] = res[thread] + (time - res[thread]);
                    k = thread;
                }
            }else{
                maps.put (thread,status);
                res[thread] = time;
                k = thread;
                if(thread != 0){
                    res[thread - 1] = time - res[thread - 1];
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "0:start:0";
        String x = "0:end:6";

        List<String> list = new ArrayList<> ();
        list.add (s);
        list.add(x);

        System.out.println (exclusiveTime (1,list));
    }
}
