package org.yaosheng.algorithm.HashTable;

import java.util.TreeMap;

/**
 * Created by yaosheng on 2022/8/16.
 */
public class HashTable<K,V> {

    // 素数表
    private final int[] capacity
            = { 53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741 };

    // 设置HashTable扩容的临界值
    private static final int upperTol = 10;
    // 设置HashTable缩容的临界值
    private static final int lowerTol = 2;
    // 设置HashTable初始大小
    private int capacityIndex = 0;

    private TreeMap<K,V>[] hashtable;
    private int M;
    private int size;

    public HashTable(){
        this.M = capacity[capacityIndex];
        size = 0;
        hashtable = new TreeMap[M];
        for(int i = 0;i < M;i ++){
            hashtable[i] = new TreeMap<> ();
        }
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

            if(size >= upperTol * M && capacityIndex + 1 < capacity.length)
                capacityIndex ++;
                resize(capacity[capacityIndex]);
        }
    }

    public V remove(K key){

        TreeMap<K,V> map = hashtable[hash (key)];
        V ret = null;
        if(map.containsKey (key)){
            ret = map.remove (key);
            size --;

            if(size < lowerTol * M && capacityIndex - 1 >= 0){
                capacityIndex --;
                resize (capacity[capacityIndex]);
            }
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
