package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/**
 * Clone graph
 * 
 */
public class Ex133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, Node> map = new HashMap<>();
        var set = new HashSet<Integer>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node item = queue.poll();
            if(set.contains(item.val)){
                continue;
            }
            set.add(item.val);
            var temp = map.getOrDefault(item.val, new Node(item.val));

            map.put(item.val, temp);

            for (Node t : item.neighbors) {
                var t2 = map.getOrDefault(t.val, new Node(t.val));
                map.put(t.val, t2);
                temp.neighbors.add(t2);
                    queue.offer(t);
                
            }
        }
        return map.get(node.val);
    }
}