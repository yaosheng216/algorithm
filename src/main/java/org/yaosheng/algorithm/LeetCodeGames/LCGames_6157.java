package org.yaosheng.algorithm.LeetCodeGames;

/**
 * Created by yaosheng on 2022/8/20.
 */
public class LCGames_6157 {

    public static int secondsToRemoveOccurrences(String s){

        if(!s.contains ("01"))
            return 0;

        int res = 0;
        String s1 = null;
        while(s.contains ("01") || s1.contains ("01")){
            if(!s.isEmpty ()){
                s1 = s.replaceAll ("01","10");
                res ++;
                s = "";
            }else if(!s1.isEmpty ()){
                s = s1.replaceAll ("01","10");
                res ++;
                s1 = "";
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String s = "11100";
        System.out.println (secondsToRemoveOccurrences (s));
    }
}
