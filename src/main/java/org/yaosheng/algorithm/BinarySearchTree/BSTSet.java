package org.yaosheng.algorithm.BinarySearchTree;

/**
 * Created by yaosheng on 2022/7/12.
 * 基于二分搜索树实现Set集合
 */
public class BSTSet <E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    BSTSet(){
        bst = new BST<> ();
    }

    @Override
    public void add(E e) {
        bst.add (e);
    }

    @Override
    public void remove(E e) {
        bst.remove (e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains (e);
    }

    @Override
    public int getSize() {
        return bst.size ();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty ();
    }
}
