package org.yaosheng.algorithm.algorithm;

import org.yaosheng.algorithm.data_structures.Array;

/**
 * Created by yaosheng on 2022/6/7.
 * 重写equlas方法
 */
public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object student){

        if(this == student) return true;
        if(student == null) return false;
        if(this.getClass () != student.getClass ()) return false;

        Student another = (Student)student;
        // toLowerCase方法，将原字符串与比对字符串都转换为小写字母
        return this.name.toLowerCase().equals (another.name);
    }

    @Override
    public int compareTo(Student another) {
        return this.score - another.score;
    }

    @Override
    public String toString(){
        return String.format ("Student(name: %s,score: %d)",name,score);
    }

    public static void main(String[] args) {

        Array<Student> arr = new Array<> ();
        arr.addLast (new Student ("Alice",100));
        arr.addLast (new Student ("James",98));
        arr.addLast (new Student ("Russel",95));

        System.out.println (arr);
    }
}
