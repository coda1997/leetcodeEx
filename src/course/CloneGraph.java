package course;

import java.util.HashMap;
public class CloneGraph {

    private HashMap<leetCode.Node,leetCode.Node> map= new HashMap<>();

    public leetCode.Node cloneGraph(leetCode.Node node) {
        if(node == null){
            return null;
        }
        if(map.containsKey(node)){
            return map.get(node);
        }

        var temp = new leetCode.Node(node.val);
        map.put(node, temp);
        for(leetCode.Node item: node.neighbors){
            temp.neighbors.add(cloneGraph(item));
        }
        return temp;
    }
}