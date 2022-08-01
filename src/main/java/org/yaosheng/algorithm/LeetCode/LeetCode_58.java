package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/8/1.
 * 获取字符串最后一个单词的长度
 */
public class LeetCode_58 {

    public static int lengthOfLastWord(String s) {

        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                return length;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println (lengthOfLastWord ("  Hello World sheng.yao   "));
    }
}
