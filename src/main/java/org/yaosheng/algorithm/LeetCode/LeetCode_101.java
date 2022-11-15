package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2022/11/15.
 */
public class LeetCode_101 {

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

    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }

    public boolean isMirror(TreeNode h1,TreeNode h2) {
        if (h1 == null ^ h2 == null) {
            return false;
        }
        if (h1 == null && h2 == null) {
            return true;
        }

        //递归比对，值是否一样，且h1的左和h2的右是否是镜面关系，h1的右和h2的左是否是镜面关系
        return h1.val == h2.val && isMirror (h1.left, h2.right) && isMirror (h1.right, h2.left);
    }
}
