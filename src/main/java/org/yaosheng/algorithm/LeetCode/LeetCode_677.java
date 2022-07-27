package org.yaosheng.algorithm.LeetCode;

import java.util.TreeMap;

/**
 * Created by yaosheng on 2022/7/27.
 */
public class LeetCode_677 {

    private class Node{

        public int value;
        public TreeMap<Character, Node> next;

        public Node(int value){
            this.value = value;
            next = new TreeMap<> ();
        }

        public Node(){
            this(0);
        }
    }

    private Node root;

    public LeetCode_677() {
        root = new Node ();
    }

    public void insert(String key, int val) {

        Node cur = root;
        for(int i = 0;i < key.length ();i ++){
            char c = key.charAt (i);
            if(cur.next.get (c) == null)
                cur.next.put (c,new Node ());
            cur = cur.next.get (c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {

        Node cur = root;
        for(int i = 0;i < prefix.length ();i ++){
            char c = prefix.charAt (i);
            if(cur.next.get (c) == null)
                return 0;
            cur = cur.next.get (c);
        }
        return sum(cur);
    }

    private int sum(Node node){

        if(node.next.size () == 0)
            return node.value;

        int res = node.value;
        for(char c: node.next.keySet ())
            res += sum(node.next.get (c));

        return res;
    }
}
