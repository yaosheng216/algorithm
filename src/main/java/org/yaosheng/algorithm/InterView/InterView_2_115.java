package org.yaosheng.algorithm.InterView;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by yaosheng on 2023/2/6.
 */
public class InterView_2_115 {

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {

        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<> ();
        int[] v = new int[n + 1];
        List<Integer>[] g = new List[n + 1];

        for (int i = 1;i <= n;i ++){
            g[i] = new ArrayList<> ();
        }
        for (int[] s : sequences) {
            for (int i = 0;i < s.length - 1;i ++) {
                v[s[i + 1]] ++;
                g[s[i]].add(s[i + 1]);
            }
        }

        int per = 0;
        for (int i = 1;i <= n;i ++){
            if (v[i] == 0) {
                deque.offer (i);
            }
        }

        while (!deque.isEmpty()) {
            if (deque.size() > 1)
                return false;
            int cur = deque.poll();
            if (nums[per ++] != cur)
                return false;
            for (int nxt : g[cur]) {
                v[nxt] --;
                if (v[nxt] == 0) {
                    deque.offer(nxt);
                }
            }
        }
        return per == n;
    }
}
