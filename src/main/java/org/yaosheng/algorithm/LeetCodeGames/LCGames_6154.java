package org.yaosheng.algorithm.LeetCodeGames;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaosheng on 2022/8/21.
 */
public class LCGames_6154 {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int N = 100010;
    int[] h = new int[N];
    int[] ne = new int[2 * N];
    int[] e = new int[2 * N];
    int[] d = new int[N];
    int idx = 0;

    public void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
    }

    public void dfs(TreeNode root) {

        if(root.left != null) {
            add(root.val, root.left.val);
            add(root.left.val, root.val);
            dfs(root.left);
        }

        if(root.right != null) {
            add(root.val, root.right.val);
            add(root.right.val, root.val);
            dfs(root.right);
        }
    }

    public int amountOfTime(TreeNode root, int start) {

        int res = 0;
        Arrays.fill(h, -1);
        Arrays.fill(d, -1);
        dfs(root);
        Queue<Integer> q = new LinkedList<> ();
        q.offer(start);
        d[start] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            res = Math.max(res, d[cur]);

            for(int i = h[cur]; i != -1; i = ne[i]) {
                int j = e[i];
                if(d[j] == -1) {
                    d[j] = d[cur] + 1;
                    q.offer(j);
                }
            }
        }
        return res;
    }
}
