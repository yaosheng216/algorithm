package org.yaosheng.algorithm.Linked;

/**
 * Created by yaosheng on 2022/6/15.
 */
public class LinkedListQueue<E> {

    private class Node {
        public E e;
        public LinkedListQueue.Node next;

        public Node(E e, LinkedListQueue.Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString ();
        }
    }

    private Node head,tail;
    private int size;

    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(E e){
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node (e);
            tail = tail.next;
        }
        size ++;
    }

    public E dequeue(){
        if(isEmpty ())
            throw new IllegalArgumentException ("Cannot dequeue from an empty queue.");
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null)
            tail = null;

        size --;
        return retNode.e;
    }

    public E getFront(){
        if(isEmpty ())
            throw new IllegalArgumentException ("Queue is empty.");
        return head.e;
    }

    public String toString(){
        StringBuilder res = new StringBuilder ();
        res.append ("Queue: front");
        Node cur = head;
        while (cur != null){
            res.append (cur + "->");
            cur = cur.next;
        }
        res.append ("NULL tail");
        return res.toString ();
    }

    public static void main(String[] args) {

        LinkedListQueue<Integer> queue = new LinkedListQueue<> ();
        for(int i = 0;i < 10;i ++){
            queue.enqueue (i);
            System.out.println (queue);

            if(i % 3 == 2){
                queue.dequeue ();
                System.out.println (queue);
            }
        }
    }
}
