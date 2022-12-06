package org.yaosheng.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaosheng on 2022/12/6.
 */
public class LeetCode_1447 {

    public static int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public List<String> simplifiedFractions(int n) {
        if (n == 1) {
            return new ArrayList<> ();
        }
        List<String> ans = new ArrayList<>();
        for (int i = 2; i <= n; i += 1) {
            ans.add(1 + "/" + i);
        }
        for (int i = 2; i <= n; i += 1) {
            for (int j = i + 1; j <= n; j += 1) {
                int gcd = gcd(j, i);
                if (gcd == 1) {
                    ans.add(i + "/" + j);
                }
            }
        }
        return ans;
    }
}
