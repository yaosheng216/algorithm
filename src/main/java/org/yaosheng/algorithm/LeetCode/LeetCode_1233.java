package org.yaosheng.algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * Created by yaosheng on 2023/2/8.
 */
public class LeetCode_1233 {

    public List<String> removeSubfolders(String[] folder) {
        return new ArrayList<> (Arrays.stream(folder).sorted().collect(Collectors.toCollection(() -> new TreeSet<> ((a, b) -> a.startsWith(b + "/") ? 0 : a.compareTo(b)))));
    }
}
