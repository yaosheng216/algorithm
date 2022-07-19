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
}
