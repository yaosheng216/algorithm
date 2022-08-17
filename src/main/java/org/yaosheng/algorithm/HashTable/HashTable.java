package org.yaosheng.algorithm.HashTable;

import java.util.TreeMap;

/**
 * Created by yaosheng on 2022/8/16.
 */
public class HashTable<K,V> {

    // 设置HashTable扩容的大小
    private static final int upperTol = 10;
    // 设置HashTable缩容的大小
    private static final int lowerTol = 2;
    // 设置HashTable初始大小
    private static final int initCapacity = 7;

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
        this(initCapacity);
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

            if(size >= upperTol * M)
                resize(2 * M);
        }
    }

    public V remove(K key){

        TreeMap<K,V> map = hashtable[hash (key)];
        V ret = null;
        if(map.containsKey (key)){
            ret = map.remove (key);
            size --;

            if(size < lowerTol * M && M / 2 >= initCapacity)
                resize(M / 2);
        }
        return ret;
    }

    // 修改HashMap中的一个元素
    public void set(K key,V value){

        TreeMap<K,V> map = hashtable[hash (key)];
        if(!map.containsKey (key))
            throw new IllegalArgumentException (key + " doesn't exist!");

        map.put (key, value);
    }

    public boolean contains(K key){
        return hashtable[hash (key)].containsKey (key);
    }

    // 从HashTable中查找一个元素
    public V get(K key){
        return hashtable[hash (key)].get (key);
    }

    // 对HashTable动态扩容/缩容
    private void resize(int newM){

        TreeMap<K,V>[] newHashTable = new TreeMap[newM];
        for(int i = 0;i < newM;i ++)
            newHashTable[i] = new TreeMap<> ();

        int oldM = M;
        this.M = newM;
        for(int i = 0;i < oldM;i ++){
            TreeMap<K,V> map = hashtable[i];
            for(K key : map.keySet ())
                newHashTable[hash (key)].put (key,map.get (key));
        }
        this.hashtable = newHashTable;
    }
}
