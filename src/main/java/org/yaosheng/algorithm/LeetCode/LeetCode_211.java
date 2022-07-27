package org.yaosheng.algorithm.LeetCode;

import java.util.TreeMap;

/**
 * Created by yaosheng on 2022/7/27.
 */
public class LeetCode_211 {

    private class Node{

        public boolean isWord;
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new TreeMap<> ();
        }

        public Node(){
            this(false);
        }
    }

    public Node root;

    public LeetCode_211() {
        root = new Node ();
    }

    public void addWord(String word) {

        Node cur = root;
        for(int i = 0;i < word.length ();i ++){
            char c = word.charAt (i);
            if(cur.next.get (c) == null)
                cur.next.put (c,new Node ());
            cur = cur.next.get (c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return match (root,word,0);
    }

    private boolean match(Node node,String word,int index){

        if(index == word.length ())
            return node.isWord;

        char c = word.charAt (index);
        if(c != '.'){
            if(node.next.get (c) == null)
                return false;
            return match (node.next.get (c),word,index + 1);
        }else{
            for(char nextChar : node.next.keySet ())
                if(match (node.next.get (nextChar),word,index + 1))
                    return true;
            return false;
        }
    }
}
