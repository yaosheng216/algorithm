package org.yaosheng.algorithm.LeetCodeGames;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by yaosheng on 2022/8/21.
 */
public class LCGames_6166 {

    public static String largestPalindromic(String num){

        int[] arr = new int[num.length ()];
        for(int i = 0;i < num.length ();i ++){
            arr[i] = Integer.parseInt (String.valueOf (num.charAt (i)));
        }

        Map<Integer,Integer> maps = new HashMap<> ();
        for(int i : arr){
            if(maps.containsKey (i)){
                maps.put (i,maps.get (i) + 1);
            }else{
                maps.put (i,1);
            }
        }

        StringBuilder str = new StringBuilder ();
        Set<Integer> set = maps.keySet ();
        int res = 0;

        if(set.size () == 1){
            if(arr[0] == 0)
                return new String (String.valueOf (arr[0]));
            else
                return num;
        }

        for(int i : set){
            if(maps.get (i) % 2 != 0)
                res = Math.max (res,i);
        }

        str.append (res);
        maps.put (res,maps.get (res) - 1);
        int x = 0;

        for(int i = 0;i <= 9;i ++){
            if(maps.containsKey (i)){
                if(maps.get (i) >= 1 && set.size () != 1){
                    for(int j = 0;j < maps.get (i) / 2;j ++){
                        str.append (i);
                        str.insert (0,i);
                    }
                    x = i;
                }
            }
        }

        if(x == 0)
            return str.toString ().replaceAll ("0","");

        return str.toString ();
    }

    public static void main(String[] args) {

        String s = "677909968843017";
        System.out.println (largestPalindromic (s));
    }
}
