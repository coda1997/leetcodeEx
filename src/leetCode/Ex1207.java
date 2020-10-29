package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ex1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : arr) {
            map.put(item, map.getOrDefault(item, 0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(var entry : map.entrySet()){
            set.add(entry.getValue());
        }
        return set.size()==map.size();
    }
}
