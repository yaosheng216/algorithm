package org.yaosheng.algorithm.data_structures;

/**
 * Created by yaosheng on 2022/6/12.
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
