package org.yaosheng.algorithm.Tire;

import org.yaosheng.algorithm.BinarySearchTree.BSTSet;
import org.yaosheng.algorithm.BinarySearchTree.FileOperation;

import java.util.ArrayList;

/**
 * Created by yaosheng on 2022/7/27.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println ("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<> ();

        if(FileOperation.readFile ("pride-and-prejudice.txt",words)){

            long start = System.nanoTime ();

            BSTSet<String> set = new BSTSet<> ();
            for(String word : words)
                set.add (word);

            for(String word : words)
                set.contains (word);

            long end = System.nanoTime ();
            double time = (end - start) / 1000000000.0;

            System.out.println ("Total different words: " + set.getSize ());
            System.out.println ("BSTSet: " + time + " s");

            start = System.nanoTime ();

            Tire tire = new Tire ();
            for(String word : words)
                tire.add (word);

            for(String word : words)
                tire.contains (word);

            end = System.nanoTime ();
            time = (end - start) / 1000000000.0;

            System.out.println ("Total different words: " + set.getSize ());
            System.out.println ("Tire: " + time + " s");
        }
    }
}
