package org.yaosheng.algorithm.BinarySearchTree;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by yaosheng on 2022/7/7.
 */
public class BSTMain {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<> ();
        Random random = new Random ();
        int[] nums = {5,3,6,8,4,2};
        for(int num : nums)
            bst.add (num);

        bst.preOrder ();
        System.out.println (bst);
        bst.preOrderNR ();
        System.out.println ();

        bst.inOrder ();
        System.out.println ();

        bst.postOrder ();
        System.out.println ();

        int n = 1000;

        for(int i = 0;i < n;i ++){
            bst.add (random.nextInt (10000));
        }

        ArrayList<Integer> list = new ArrayList<> ();
        while(!bst.isEmpty ()){
            list.add (bst.removeMin ());
        }
        System.out.println (list);

        for(int i = 1;i < list.size ();i ++)
            if(list.get (i - 1) > list.get (i))
                throw new IllegalArgumentException ("Error");

        System.out.println ("removeMin test completed");

        for(int i = 0;i < n;i ++){
            bst.add (random.nextInt (10000));
        }

        list = new ArrayList<> ();
        while(!bst.isEmpty ()){
            list.add (bst.removeMax ());
        }
        System.out.println (list);

        for(int i = 1;i < list.size ();i ++)
            if(list.get (i - 1) > list.get (i))
                throw new IllegalArgumentException ("Error");

        System.out.println ("removeMax test completed");
    }
}
