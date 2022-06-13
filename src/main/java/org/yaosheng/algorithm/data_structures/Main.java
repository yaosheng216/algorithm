package org.yaosheng.algorithm.data_structures;

import java.util.Random;

/**
 * Created by yaosheng on 2022/6/11.
 */
public class Main {

    // 测试使用q运行opCount个enqueue和dequeue操作所需要的时间，单位:秒
    private static double testQueue(Queue<Integer> q,int opCount){

        long start = System.nanoTime ();
        Random random = new Random ();
        for(int i = 0;i < opCount;i ++)
            q.enqueue (random.nextInt (Integer.MAX_VALUE));
        for(int i = 0;i < opCount;i ++)
            q.dequeue ();

        long end = System.nanoTime ();
        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {

        // 泛型中不能存储基本数据类型
//        Array<Integer> arr = new Array ();
//        for(int i = 0;i < 10;i ++)
//            arr.addLast (i);
//        System.out.println (arr);
//
//        arr.add (1,100);
//        System.out.println (arr);
//
//        arr.addFirst (-1);
//        System.out.println (arr);
//
//        ArrayStack<Integer> stack = new ArrayStack<> ();
//        for(int i = 0;i < 5;i ++){
//            stack.push (i);
//            System.out.println (stack);
//        }
//
//        stack.pop ();
//        System.out.println (stack);

        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<> ();
        double time1 = testQueue (arrayQueue,opCount);
        System.out.println ("ArrayQueue,time " + time1 + "s");

        LoopQueue<Integer> loopQueue = new LoopQueue<> ();
        double time2 = testQueue (loopQueue,opCount);
        System.out.println ("LoopQueue,time " + time2 + "s");

        LinkedList<Integer> linkedList = new LinkedList<> ();
        for(int i = 0;i < 5;i ++){
            linkedList.addFirst (i);
            System.out.println (linkedList);
        }
        linkedList.add (2,666);
        System.out.println (linkedList);

        linkedList.remove (2);
        System.out.println (linkedList);

        linkedList.removeFirst ();
        System.out.println (linkedList);
    }
}
