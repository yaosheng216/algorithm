package org.yaosheng.algorithm.RedBlackTree;

import org.yaosheng.algorithm.AVLTree.AVLTree;

import org.yaosheng.algorithm.BinarySearchTree.FileOperation;
import org.yaosheng.algorithm.Map.BSTMap;

import java.util.ArrayList;

/**
 * Created by yaosheng on 2022/8/4.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words)) {

            System.out.println("Total words: " + words.size());
            // Test BST
            long start = System.nanoTime();

            BSTMap<String, Integer> bst = new BSTMap<> ();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }
            for(String word: words)
                bst.contains(word);

            long end= System.nanoTime();
            double time = (end - start) / 1000000000.0;

            System.out.println("BST: " + time + " s");

            // Test AVL
            start = System.nanoTime();
            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }
            for(String word: words)
                avl.contains(word);

            end = System.nanoTime();

            time = (end - start) / 1000000000.0;
            System.out.println("AVL: " + time + " s");

            // Test RBTree
            start = System.nanoTime();
            RBTree<String, Integer> rbt = new RBTree<>();
            for (String word : words) {
                if (rbt.contains(word))
                    rbt.set(word, rbt.get(word) + 1);
                else
                    rbt.add(word, 1);
            }

            for(String word: words)
                rbt.contains(word);

            end = System.nanoTime();
            time = (end - start) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");
        }
        System.out.println();
    }
}
