package org.yaosheng.algorithm.algorithm;

/**
 * Created by yaosheng on 2022/6/7.
 * 使用泛型
 */
public class Code_02 {

    public static <E> int search(E[] data,E target){

        for(int i = 0;i < data.length;i ++){
            if(data[i].equals (target)){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Integer[] data = ArrayGenerator.generateOrderArray (10000000);
        long start = System.currentTimeMillis ();
        System.out.println (search (data,10000000));
        long end = System.currentTimeMillis ();
        System.out.println ("Time is:" + (end - start));

        Student[] students = {new Student ("Alice",98),new Student ("Great",100),new Student ("Mark",95)};
        Student great = new Student ("great",100);
        int res = search (students,great);
        System.out.println (res);
    }
}
