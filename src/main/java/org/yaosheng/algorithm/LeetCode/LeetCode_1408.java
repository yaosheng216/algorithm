package org.yaosheng.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaosheng on 2022/8/6.
 */
public class LeetCode_1408 {

    public static List<String> stringMatching(String[] words){

        List<String> res = new ArrayList<>();
        for (String word : words) {
            for (int i = 0; i < words.length; i ++) {
                if (word.length() >= words[i].length())
                    continue;
                if (words[i].contains(word)) {
                    res.add(word);
                    break;
                }
            }
        }
        return res;

    }
}
