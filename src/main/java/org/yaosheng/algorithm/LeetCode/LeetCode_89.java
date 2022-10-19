package org.yaosheng.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaosheng on 2022/10/19.
 */
public class LeetCode_89 {

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<> ();
        for(int i = 0; i < 1 << n;i ++)
            ret.add(i ^ i >> 1);
        return ret;
    }
}
