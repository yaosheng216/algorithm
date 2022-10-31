package org.yaosheng.algorithm.LeetCode;

import java.util.Stack;

/**
 * Created by yaosheng on 2022/10/31.
 */
public class LeetCode_71 {

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] items = path.split("/");

        for (String item : items) {
            if (item.isEmpty() || item.equals(".")) continue;
            if (item.equals("..")) {
                if (!stack.empty()) stack.pop();
            } else {
                stack.push(item);
            }
        }
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        System.out.println (simplifyPath ("/home/"));
    }
}
