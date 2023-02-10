package org.yaosheng.algorithm.LeetCode;

/**
 * Created by yaosheng on 2023/2/10.
 * DFS（深度优先）
 */
public class LeetCode_116 {

    class Node {

        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node(){}
        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if(root != null){
            dfs(root);
        }
        return root;
    }

    public void dfs(Node root){
        if(root.left != null && root.right != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
            dfs(root.left);
            dfs(root.right);
        }
    }
}
