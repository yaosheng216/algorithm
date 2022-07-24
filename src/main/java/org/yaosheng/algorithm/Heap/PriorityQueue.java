package org.yaosheng.algorithm.Heap;

import org.yaosheng.algorithm.Data_Structures.Queue;

/**
 * Created by yaosheng on 2022/7/21.
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<> ();
    }

    @Override
    public int getSize(){
        return maxHeap.size ();
    }

    @Override
    public boolean isEmpty(){
        return maxHeap.isEmpty ();
    }

    @Override
    public E getFront(){
        return maxHeap.findMax ();
    }

    @Override
    public void enqueue(E e){
        maxHeap.add(e);
    }

    @Override
    public E dequeue(){
        return maxHeap.extractMax ();
    }
}
