package review;

import java.util.HashMap;

public class LRUCache {
    //hashmap to save entry for put and get;
    //then use a linkedList
    class Entry{
        int key;
        int value;
        Entry pre;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private HashMap<Integer, Entry> map;
    private final int capacity;
    private Entry head;
    private int len;
    private void insertHead(Entry entry) {
        if (head == null) {
            head = entry;
            entry.next = entry.pre = entry;
        }else{
            entry.next = head;
            entry.pre = head.pre;
            head.pre =entry;
            entry.pre.next = entry;
            head = entry;
        }
    }
    private void delete(Entry entry){
        if (entry.next == entry) {
            head = null;
        }else{
            var pre = entry.pre;
            var next = entry.next;
            pre.next = next;
            next.pre = pre;
            if (entry == head) {
                head = next;
            }
        }
    }
    private void deleteTail() {
        delete(head.pre);
    }

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity =capacity;
        len = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }else{
            Entry entry = map.get(key);
            delete(entry);
            insertHead(entry);
            return entry.value;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            entry.value = value;
            delete(entry);
            insertHead(entry);
        }else{
            if (len < capacity) {
                len++;
            }else{
                map.remove(head.pre.key);
                deleteTail();
            }
            Entry entry = new Entry(key, value);
            map.put(key, entry);
            insertHead(entry);
        }
    }
}
