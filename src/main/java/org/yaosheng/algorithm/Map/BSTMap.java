package org.yaosheng.algorithm.Map;

import org.yaosheng.algorithm.BinarySearchTree.FileOperation;
import java.util.ArrayList;

/**
 * Created by yaosheng on 2022/7/13.
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V> {

    public class Node{

        public K key;
        public V value;
        public Node left,right;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add (root,key,value);
    }

    // 向以node为根的二分搜索树中插入元素(key,node)，递归算法实现
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value){

        if(node == null){
            size ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0
            node.value = value;

        return node;
    }

    private Node getNode(Node node,K key){

        if(node == null)
            return null;

        if(key.compareTo (node.key) == 0)
            return node;
        else if(key.compareTo (node.key) < 0)
            return getNode (node.left,key);
        else
            return getNode (node.right,key);
    }

    @Override
    public V remove(K key) {

        Node node = getNode (root,key);
        if(node != null){
            root = remove (root,key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if(node == null )
            return null;

        if(key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            return node;
        }else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            return node;
        }else{
            // key.compareTo(node.key) == 0
            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            // 待删除节点左右子树均不为空的情况
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }

    @Override
    public boolean contains(K key) {
        return getNode (root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode (root,key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {

        Node node = getNode (root,key);
        if(node == null)
            throw new IllegalArgumentException (key + " doesn't exist!");
        node.value = value;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public static void main(String[] args) {

        System.out.println ("Pride and Prejudice");
        ArrayList<String> words = new ArrayList<> ();

        if(FileOperation.readFile ("pride-and-prejudice.txt",words)){

            System.out.println ("Total words : " + words.size ());

            BSTMap<String,Integer> map = new BSTMap<> ();
            for(String word : words) {
                if (map.contains (word))
                    map.set (word, map.get (word) + 1);
                else
                    map.add (word, 1);
            }

            System.out.println ("Total different words: " + map.getSize ());
            System.out.println ("Frequency of PRIDE: " + map.get("pride"));
            System.out.println ("Frequency of PREJUDICE: " + map.get ("prejudice"));
        }
    }
}
