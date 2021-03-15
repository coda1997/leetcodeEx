package temp;

import java.util.LinkedList;
import java.util.Map;

class MyHashMap {
    class Entry{
        int value;
        int key;
        Entry(int key, int value){
            this.key = key;
            this.value = value;
            next = null;
        }
        Entry next;
    }
    private LinkedList<Entry>[] entries;
    private int length = 512;
    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        entries = new LinkedList[length];
        for (int i = 0; i < length; i++) {
            entries[i] = new LinkedList<>();
        }
    }

    private int hashIndex(int key){
        return (key)&(length-1);
    }

    private Entry findEntry(LinkedList<Entry> list, int key) {
        for (Entry item : list) {
            if (item.key == key) {
                return item;
            }
        }
        return null;
    }
    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int hash = hashIndex(key);
        Entry temp;
        if ((temp=findEntry(entries[hash], key)) == null) {
            entries[hash].addFirst(new Entry(key, value));
        }else{
            temp.value = value;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        var entry = entries[hashIndex(key)];
        Entry temp = findEntry(entry, key);
        if (temp == null) {
            return -1;
        }else{
            return temp.value;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int hash = hashIndex(key);
        var entry = findEntry(entries[hash], key);
        if (entry != null) {
            entries[hash].remove(entry);
        }
    }
}
