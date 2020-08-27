package leetCode;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Ex332 {
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    List<String> itinerary = new LinkedList<>();
    //We use priority queue to handle the dis string in order.

    public List<String> findItinerary(List<List<String>> tickets) {
        //Initialization
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            if(!map.containsKey(src)){
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    private void dfs(String cur){
        while(map.containsKey(cur)&&map.get(cur).size()>0){
            var temp = map.get(cur).poll();
            dfs(temp);
        }
        itinerary.add(cur);
    }
    
}