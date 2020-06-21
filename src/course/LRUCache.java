package course;

import java.util.HashMap;

public class LRUCache {
    class Node{
        int val;
        Node pre;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    class BioLinkedList{
        private Node head;
        private Node end;
        private int length = 0;
        void remove(Node e){
            if(e.pre==null&&e.next==null){
                if(e!=head){
                    return;
                }
            }
            length--;
            if(e==head){
                var t = head.next;
                head.next = null;
                head = t;
                if(t!=null){
                    t.pre = null;
                }
                return;
            }
            if(e==end){
                var t = end.pre;
                end.pre = null;
                t.next = null;
                if(t!=head){
                    end = t;
                }else{
                    end=null;
                }
                return;
            }
            var t1 = e.pre;
            var t2 = e.next;
            e.pre=null;
            e.next = null;
            t1.next = t2;
            t2.pre = t1;
            return;
        }
        void add(Node e){
            length++;
            if(head==null){
                head = e;
                return;
            }
            if(end==null){
                end = e;
                head.next = e;
                end.pre = head;
                return;
            }
            var t = end;
            end = e;
            t.next = e;
            e.pre = t;
        }

        int getNode(Node e){
            if(e.val==-1){
                return -1;
            }
            remove(e);
            add(e);
            return e.val;
        }
    }

    private int capacity;
    private HashMap<Integer,Node> map;
    private BioLinkedList bioLinkedList;
    //使用一个hashmap和双向链表；
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        bioLinkedList = new BioLinkedList();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            var node =map.get(key);
            return bioLinkedList.getNode(node);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            bioLinkedList.remove( map.get(key));
        }
        if(bioLinkedList.length==capacity){
            bioLinkedList.head.val=-1;
            bioLinkedList.remove(bioLinkedList.head);

        }
        var node = new Node(value);
        bioLinkedList.add(node);
        map.put(key, node);
        
    }

    public static void main(String[] args) {
        var cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(2, 2);
        cache.put(2, 2);
        cache.put(2, 2);
        cache.put(2, 2);
        cache.put(2, 2);
        cache.put(1, 3);
        cache.put(1, 3);
        cache.put(1, 3);

    }
}