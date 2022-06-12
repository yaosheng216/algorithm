package org.yaosheng.algorithm.data_structures;

/**
 * Created by yaosheng on 2022/6/12.
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
