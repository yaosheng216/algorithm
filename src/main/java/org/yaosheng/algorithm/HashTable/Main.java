package org.yaosheng.algorithm.HashTable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by yaosheng on 2022/8/10.
 */
public class Main {

    public static void main(String[] args) {

        int a = 42;
        System.out.println (((Integer)a).hashCode ());

        int b = -42;
        System.out.println (((Integer)b).hashCode ());

        double c = 3.1415926;
        System.out.println (((Double)c).hashCode ());

        String s = "yaosheng";
        System.out.println (s.hashCode ());

        Student student = new Student (6,2,"sheng","yao");
        System.out.println (student.hashCode ());

        HashSet<Student> set = new HashSet<> ();
        set.add (student);

        HashMap<Student,Integer> scores = new HashMap<> ();
        scores.put (student,100);

        /**
         * 如果类方法没有自定义hashCode函数，那么将调用Java自带的hashCode
         */
        Student student1 = new Student (6,2,"sheng","yao");
        System.out.println (student1.hashCode ());

    }
}
