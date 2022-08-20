package org.yaosheng.algorithm.LeetCode;

import java.util.Arrays;

/**
 * Created by yaosheng on 2022/8/20.
 */
public class LeetCode_654 {

    public static class TreeNode {

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

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if(nums.length == 0)
            return null;

        TreeNode node = new TreeNode ();
        int mid = 0,j = 0;

        for(int i = 0;i < nums.length;i ++){
            if(nums[i] > mid) {
                mid = nums[i];
                j = i;
            }
        }

        node.val = nums[j];
        node.left = constructMaximumBinaryTree (Arrays.copyOfRange (nums,0,j));
        node.right = constructMaximumBinaryTree (Arrays.copyOfRange (nums,j + 1,nums.length));

        return node;
    }
}
