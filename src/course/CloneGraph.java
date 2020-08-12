package course;

import java.util.HashMap;
import leetCode.Node;

public class CloneGraph {

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