package org.yaosheng.algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaosheng on 2022/11/15.
 */
public class LeetCode_146 {

    private final Map<Integer, Entry> map;
    private final List list;
    private final int capacity;

    public LeetCode_146(int capacity) {
        this.map = new HashMap<> ();
        this.list = new List();
        this.capacity = capacity;
    }

    public LeetCode_146(Map<Integer, Entry> map, List list, int capacity) {
        this.map = map;
        this.list = list;
        this.capacity = capacity;
    }

    public int get(int key) {
        Entry entry = map.get(key);
        if (entry == null) {
            return -1;
        }
        list.remove(entry);
        list.addHead(entry);
        return entry.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            entry.value = value;
            list.remove(entry);
            list.addHead(entry);
        } else {
            Entry entry = new Entry(key, value);
            map.put(key, entry);
            list.addHead(entry);
            if (list.size() > capacity) {
                map.remove(list.removeLast().key);
            }
        }
    }

    private static class List {
        private Entry head;
        private Entry tail;
        private int size;

        List() {
            head = new Entry();
            tail = new Entry();
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addHead(Entry entry) {
            entry.next = head.next;
            entry.prev = head;
            entry.next.prev = entry;
            entry.prev.next = entry;
            size++;
        }

        Entry removeLast() {
            Entry entry = tail.prev;
            remove(tail.prev);
            return entry;
        }

        void remove(Entry entry) {
            entry.prev.next = entry.next;
            entry.next.prev = entry.prev;
            size--;
        }

        int size() {
            return size;
        }
    }

    private static class Entry {
        int key;
        int value;
        Entry prev;
        Entry next;

        public Entry() {
        }

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
