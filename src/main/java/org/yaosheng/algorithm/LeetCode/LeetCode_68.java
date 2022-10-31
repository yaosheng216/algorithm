package org.yaosheng.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaosheng on 2022/10/31.
 */
public class LeetCode_68 {

    public List<String> fullJustify(String[] words, int maxWidth) {

        StringBuilder cur = new StringBuilder();
        List<String> res = new ArrayList<> ();
        int len = maxWidth;

        for (int i = 0; i < words.length; i ++) {
            if (i == 0) {
                cur.append(words[i]);
                if (i == words.length - 1) {
                    int need = len - cur.length();
                    while (need > 0) {
                        cur.append(" ");
                        need --;
                    }
                    res.add(cur.toString());
                }
                continue;
            }
            if (cur.length() + words[i].length() + 1 <= len) {
                cur.append(" " + words[i]);
                if (i == words.length - 1) {
                    int need = len - cur.length();
                    while (need > 0) {
                        cur.append(" ");
                        need --;
                    }
                    res.add(cur.toString());
                }
            } else {
                String s1 = cur.toString();
                String[] c1 = s1.split(" ");

                int num = c1.length;
                int stars = len - (s1.length() - num + 1);
                int every;
                int last;
                int before = 0;

                StringBuilder sb = new StringBuilder();
                if (num == 1) {
                    sb.append(c1[0]);
                    int count = len - c1[0].length();
                    while (count > 0) {
                        sb.append(" ");
                        count --;
                    }
                } else {
                    if (stars % (num - 1) == 0) {
                        every = stars / (num - 1);
                        last = every;
                    } else {
                        every = stars / (num - 1) + 1;
                        before = stars % (num - 1);
                        last = stars / (num - 1);
                    }
                    for (int j = 0; j < num; j++) {
                        if (j == num - 1) {
                            sb.append(c1[j]);
                        } else {
                            if (before > 0) {
                                sb.append(c1[j]);
                                int count = 0;
                                while (count < every) {
                                    sb.append(" ");
                                    count ++;
                                }
                                before --;
                            } else {
                                sb.append(c1[j]);
                                int count = 0;
                                while (count < last) {
                                    sb.append(" ");
                                    count ++;
                                }
                            }
                        }
                    }
                }
                res.add(sb.toString());
                cur = new StringBuilder();
                cur.append(words[i]);
                if (i == words.length - 1) {
                    int need = len - cur.length();
                    while (need > 0) {
                        cur.append(" ");
                        need --;
                    }
                    res.add(cur.toString());
                }
            }
        }
        return res;
    }
}
