package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ex692 {
    public List<String> topKFrequent(String[] words, int k) {
        var map = new HashMap<String, Integer>();
        for (String word :
                words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        var retList = new ArrayList<String>();
        retList.addAll(map.keySet());
        retList.sort((o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o1.compareTo(o2);
            } else {
                return map.get(o2) - map.get(o1);
            }
        });
        return retList.subList(0, k);
    }
}
