package org.yaosheng.algorithm.LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yaosheng on 2022/10/9.
 */
public class LeetCode_856 {

    public int scoreOfParentheses(String s) {

        Deque<Character> stack = new LinkedList<> ();
        int result = 0;
        boolean flag = true;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.add(ch);
                flag = true;
            }else{
                if(flag) {
                    result += Math.pow(2,stack.size() - 1);
                    flag = false;
                }
                stack.pop();
            }
        }
        return result;
    }
}
