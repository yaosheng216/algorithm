package org.yaosheng.algorithm.LeetCode;

import java.util.TreeSet;

/**
 * Created by yaosheng on 2022/7/12.
 */
public class LeetCode_804 {

    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<> ();
        for(String word : words){

            StringBuilder res = new StringBuilder ();
            for(int i = 0;i < word.length ();i ++){
                res.append (codes[word.charAt (i) - 'a']);
            }
            set.add (res.toString ());
        }
        return set.size ();
    }





}
