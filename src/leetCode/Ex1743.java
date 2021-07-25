package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Ex1743 {
    public int[] restoreArray(int[][] adjacentPairs) {
        var map = new HashMap<Integer, List<Integer>>();
        for (var pair : adjacentPairs) {
            map.putIfAbsent(pair[0], new ArrayList<>());
            map.putIfAbsent(pair[1], new ArrayList<>());
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        int[] res = new int[adjacentPairs.length + 1];
        for (var entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                res[0] = entry.getKey();
                break;
            }
        }
        res[1] = map.get(res[0]).get(0);
        for (int i = 2; i < res.length; i++) {
            var v = map.get(res[i - 1]);
            res[i] = v.get(0) == res[i - 2] ? v.get(1) : v.get(0);
        }
        return res;
    }
}
