package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2023/2/1.
 */
public class LeetCode_2325 {

    public String decodeMessage(String key, String message) {
        char[] keys = new char[26];
        char cur = 'a';
        for (char c : key.toCharArray()) {
            if (c != ' ' && keys[c - 'a'] == 0) {
                keys[c - 'a'] = cur++;
                if (cur == 'z' + 1) {
                    break;
                }
            }
        }
        char[] chars = message.toCharArray();
        for(int i = 0; i < message.length(); i++) {
            if (chars[i] != ' ') {
                chars[i] = keys[chars[i] - 'a'];
            }
        }
        return new String(chars);
    }
}
