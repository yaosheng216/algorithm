package org.yaosheng.algorithm.LeetCode;

import java.util.Stack;

/**
 * Created by yaosheng on 2022/6/12.
 *
 * Leetcode No.20
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class LeetCode_20 {

    public boolean isValid(String s){

        Stack<Character> stack = new Stack<> ();
        for(int i = 0;i < s.length ();i ++){

            char c = s.charAt (i);
            if(c == '(' || c == '[' || c == '{')
                stack.push (c);
            else {
                if(stack.isEmpty () )
                    return false;
                char topChar = stack.pop ();
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty ();
    }
}
