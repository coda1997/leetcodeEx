package temp;

import java.util.HashMap;

public class LRU {
    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private int len;

    public LRU(int n) {
        capacity = n;
        map = new HashMap<>();
        head = null;
        len = 0;
    }

    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }

        Node pre;
        Node next;
    }

    private void insertHead(Node item) {
        if (head == null) {
            item.pre = item;
            item.next = item;
        } else {
            item.pre = head.pre;
            head.pre = item;
            item.next = head;
            item.pre.next = item;
        }
        head = item;
    }

    private void delete(Node item) {
        var next = item.next;
        var pre = item.pre;
        //if item is a new node, which is not inserted into the linked list,
        //it would not be deleted because both its pointers of pre and next are null.
        if (next == null || pre == null) {
            return;
        }
        if (next == item) {
            head=null;
        }
        pre.next = next;
        next.pre = pre;
        item.next = null;
        item.pre = null;
        if (item == head) {
            head = next;
        }
    }

    private void update(Node item) {
        delete(item);
        insertHead(item);
    }

    private void removeLast() {
        delete(head.pre);
    }

    public void put(int k, int v) {
        Node item;
        if (map.containsKey(k)) {
            item = map.get(k);
            item.value = v;
        }else{
            item = new Node(k, v);
            map.put(k, item);
            if (len < capacity) {
                len++;
            }else{
                map.remove(head.pre.key);
                removeLast();
            }
        }
        update(item);
    }

    public int get(int k) {
        if (map.containsKey(k)){
            var item = map.get(k);
            update(item);
            return item.value;
        }
        return -1;
    }
}
