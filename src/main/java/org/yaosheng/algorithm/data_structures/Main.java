package org.yaosheng.algorithm.data_structures;

/**
 * Created by yaosheng on 2022/6/11.
 */
public class Main {

    public static void main(String[] args) {

        // 泛型中不能存储基本数据类型
        Array<Integer> arr = new Array ();
        for(int i = 0;i < 10;i ++)
            arr.addLast (i);
        System.out.println (arr);

        arr.add (1,100);
        System.out.println (arr);

        arr.addFirst (-1);
        System.out.println (arr);

        ArrayStack<Integer> stack = new ArrayStack<> ();
        for(int i = 0;i < 5;i ++){
            stack.push (i);
            System.out.println (stack);
        }

        stack.pop ();
        System.out.println (stack);
    }
}
