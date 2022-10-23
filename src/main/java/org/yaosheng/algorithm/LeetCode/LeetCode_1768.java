package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/10/23.
 */
public class LeetCode_1768 {

    public String mergeAlternately(String word1, String word2) {

        StringBuilder res = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int i = 0;

        while(i < len1 && i < len2) {
            res.append(word1.charAt(i));
            res.append(word2.charAt(i));
            i ++;
        }
        if(i < len1) {
            res.append(word1.substring(i, len1));
        }
        if(i < len2) {
            res.append(word2.substring(i, len2));
        }
        return res.toString();
    }
}
