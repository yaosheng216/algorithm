package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2023/2/6.
 * DFS
 */
public class LeetCode_2331 {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean evaluateTree(TreeNode root){
        return dfs(root);
    }

    private boolean dfs(TreeNode root){
        if(root.left == null && root.right == null)
            return root.val == 1;
        if(root.val == 2) {
            return dfs(root.left) || dfs(root.right);
        }else{
            return dfs(root.left) && dfs(root.right);
        }
    }
}
