package course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CopyRandomList {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node res = new Node(head.val);
        var t = res;
        var currentHead = head.next;
        HashMap<Node,List<Node>> map = new HashMap<>();
        
        var lt = new ArrayList<Node>();
        lt.add(t);
        map.put(head.random, lt );
        
        while(currentHead!=null){
            t.next = new Node(currentHead.val);
            var ramdom = currentHead.random;
            if(map.containsKey(ramdom)){
                map.get(ramdom).add(t.next);
            }else{
                var l = new ArrayList<Node>();
                l.add(t.next);
                map.put(ramdom, l);
            }
            t=t.next;
            currentHead = currentHead.next;
        }
        t=res;
        currentHead = head;
        while(currentHead!=null){
            if(map.containsKey(currentHead)){
                var l = map.get(currentHead);
                for (Node node : l) {
                    node.random=t;
                }
            }
            t=t.next;
            currentHead=currentHead.next;
        }

        return res;
    }
}