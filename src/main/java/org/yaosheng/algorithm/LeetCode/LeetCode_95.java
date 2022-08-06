package org.yaosheng.algorithm.LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yaosheng on 2022/8/5.
 */
public class LeetCode_95 {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {

        if (n == 0)
            return new LinkedList<> ();
        return generate (1, n);
    }

    private List<TreeNode> generate(int l, int r) {

        List<TreeNode> list = new LinkedList<> ();
        if (l > r) {
            list.add (null);
            return list;
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> left = generate (l, i - 1);
            List<TreeNode> right = generate (i + 1, r);
            for (TreeNode lh : left) {
                for (TreeNode rh : right) {
                    TreeNode root = new TreeNode (i);
                    root.left = lh;
                    root.right = rh;
                    list.add (root);
                }
            }
        }
        return list;
    }
}