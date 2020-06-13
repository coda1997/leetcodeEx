package course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    private HashMap<Node,Node> map= new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }

        var temp = new Node(node.val);
        map.put(node, temp);
        for(var item: node.neighbors){
            temp.neighbors.add(cloneGraph(item));
        }

        return temp;
    }
}