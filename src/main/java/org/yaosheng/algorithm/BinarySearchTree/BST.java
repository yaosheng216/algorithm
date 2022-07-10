package org.yaosheng.algorithm.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by yaosheng on 2022/7/7.
 * 二分搜索树
 */
public class BST <E extends Comparable<E>> {

    public class Node {

        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add (root,e);
    }

    // 向以node为根的二分搜索树中插入元素E，递归算法实现
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node,E e){

        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo (node.e) < 0)
            node.left = add(node.left,e);
        else if(e.compareTo (node.e) > 0)
            node.right = add(node.right,e);

        return node;
    }

    public boolean contains(E e){
        return contains (root,e);
    }

    private boolean contains(Node node,E e){

        if(node == null)
            return false;

        if(e.compareTo (node.e) == 0)
            return true;
        else if(e.compareTo (node.e) < 0)
            return contains (node.left,e);
        else
            return contains (node.right,e);
    }

    // 前序遍历
    public void preOrder(){
        preOrder (root);
    }

    private void preOrder(Node node){

        if(node == null)
            return;

        System.out.println (node.e);
        preOrder (node.left);
        preOrder (node.right);
    }

    // 深度优先
    public void preOrderNR(){

        Stack<Node> stack = new Stack<> ();
        stack.push (root);

        while(!stack.isEmpty ()){
            Node cur = stack.pop ();
            System.out.println (cur.e);

            if(cur.right != null)
                stack.push (cur.right);
            if(cur.left != null)
                stack.push (cur.left);
        }
    }

    // 中序遍历
    public void inOrder(){
        inOrder (root);
    }

    private void inOrder(Node node){

        if(node == null)
            return;
        inOrder (node.left);
        System.out.println (node.e);
        inOrder (node.right);
    }

    // 后序遍历
    public void postOrder(){
        postOrder (root);
    }

    private void postOrder(Node node){

        if(node == null)
            return;

        postOrder (node.left);
        postOrder (node.right);
        System.out.println (node.e);
    }

    // 广度优先
    public void levelOrder(){

        Queue<Node> q = new LinkedList<> ();
        q.add (root);

        while(!q.isEmpty ()){
            Node cur = q.remove ();
            System.out.println (cur.e);

            if(cur.left != null)
                q.add (cur.left);
            if(cur.right != null)
                q.add (cur.right);
        }
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder ();
        generateBSTString(root,0,res);
        return res.toString ();
    }

    private void generateBSTString(Node node,int depth,StringBuilder res){

        if(node == null){
            res.append (generateDepthString(depth) + "null\n");
            return;
        }

        res.append (generateDepthString (depth) + node.e + "\n");
        generateBSTString (node.left,depth + 1,res);
        generateBSTString (node.right,depth + 1,res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder ();
        for(int i = 0;i < depth;i ++)
            res.append ("--");
        return res.toString ();
    }
}
