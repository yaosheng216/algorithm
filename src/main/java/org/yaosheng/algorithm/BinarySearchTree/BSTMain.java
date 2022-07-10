package org.yaosheng.algorithm.BinarySearchTree;

/**
 * Created by yaosheng on 2022/7/7.
 */
public class BSTMain {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<> ();
        int[] nums = {5,3,6,8,4,2};
        for(int num : nums)
            bst.add (num);

        bst.preOrder ();
        System.out.println (bst);

        bst.inOrder ();
        System.out.println ();

        bst.postOrder ();
        System.out.println ();
    }
}
