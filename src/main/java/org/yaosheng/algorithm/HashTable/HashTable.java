package org.yaosheng.algorithm.HashTable;

import java.util.TreeMap;

/**
 * Created by yaosheng on 2022/8/16.
 */
public class HashTable<K,V> {

    private TreeMap<K,V>[] hashtable;
    private int M;
    private int size;

    public HashTable(int M){
        this.M = M;
        size = 0;
        hashtable = new TreeMap[M];
        for(int i = 0;i < M;i ++){
            hashtable[i] = new TreeMap<> ();
        }
    }

    public HashTable(){
        this(97);
    }

    private int hash(K key){
        return (key.hashCode () & 0x7fffffff) % M;
    }

    public int getSize(){
        return size;
    }

    public void add(K key,V value){

        TreeMap<K,V> map = hashtable[hash (key)];
        if(hashtable[hash (key)].containsKey (key))
            map.put (key, value);
        else{
            map.put (key, value);
            size ++;
        }
    }
}
