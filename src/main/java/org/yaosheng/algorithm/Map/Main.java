package org.yaosheng.algorithm.Map;

import org.yaosheng.algorithm.BinarySearchTree.FileOperation;
import java.util.ArrayList;

/**
 * Created by yaosheng on 2022/7/13.
 */
public class Main {

    private static double testMap(Map<String, Integer> map, String filename){

        long startTime = System.nanoTime();
        System.out.println(filename);

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words){
                if(map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static int strLength(String s){

        String[] str = s.split (" ");
        int num = str[str.length - 1].length ();

        return num;
    }

    public static void main(String[] args) {

        String filename = "pride-and-prejudice.txt";

        BSTMap<String, Integer> bstMap = new BSTMap<>();
        double time1 = testMap(bstMap, filename);
        System.out.println("BST Map: " + time1 + " s");

        System.out.println();

        LinkedListMap<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testMap(linkedListMap, filename);

        System.out.println("Linked List Map: " + time2 + " s");

        System.out.println (strLength ("Hello World yaosheng"));
    }
}
