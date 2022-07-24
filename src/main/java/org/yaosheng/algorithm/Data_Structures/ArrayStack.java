package org.yaosheng.algorithm.Data_Structures;

/**
 * Created by yaosheng on 2022/6/12.
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<> (capacity);
    }

    public ArrayStack(){
        array = new Array<> ();
    }

    @Override
    public int getSize() {
        return array.getSize ();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty ();
    }

    public int getCapacity(){
        return array.getCapacity ();
    }

    @Override
    public void push(E e) {
        array.addLast (e);
    }

    @Override
    public E pop() {
        return array.removeLast ();
    }

    @Override
    public E peek() {
        return array.getLast ();
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder ();
        builder.append ("Stack: ");
        builder.append ('[');
        for(int i = 0;i < array.getSize ();i ++){
            builder.append (array.get (i));
            if(i != array.getSize () - 1)
                builder.append (", ");
        }
        builder.append ("] top");
        return builder.toString ();
    }
}
