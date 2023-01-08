package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2023/1/8.
 */
public class LeetCode_1685 {

    public static int prefixCount(String[] words, String pref) {
        int res = 0;
        for(int i = 0;i < words.length;i ++){
            if(words[i].length () >= pref.length ()){
                if(words[i].substring (0, pref.length ()).equals (pref)){
                    res ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] str = {"leetcode","win","loops","success"};
        System.out.println (prefixCount (str,"code"));
    }
}
