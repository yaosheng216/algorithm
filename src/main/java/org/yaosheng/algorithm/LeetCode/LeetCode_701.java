package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2023/1/8.
 */
public class LeetCode_701 {

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

    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root == null){
            return new TreeNode(val);
        }

        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        } else {
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}
