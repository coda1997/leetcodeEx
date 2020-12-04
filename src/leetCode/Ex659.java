package leetCode;

import java.util.HashMap;

public class Ex659 {
    public boolean isPossible(int[] nums) {
        var map = new HashMap<Integer, Integer>();
        var cs = new HashMap<Integer, Integer>();
        for (int item : nums) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        for (int item : nums) {
            while (map.get(item) > 0) {
                if (cs.getOrDefault(item - 1, 0) > 0) {
                    cs.put(item - 1, cs.get(item - 1) - 1);
                    cs.put(item, cs.getOrDefault(item, 0) + 1);
                    map.put(item, map.get(item) - 1);
                } else if (map.getOrDefault(item + 1, 0) > 0 && map.getOrDefault(item + 2, 0) > 0) {
                    cs.put(item + 2, cs.getOrDefault(item + 2, 0) + 1);
                    map.put(item + 1, map.get(item + 1) - 1);
                    map.put(item + 2, map.get(item + 2) - 1);
                    map.put(item, map.get(item) - 1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var o = new Ex659();
        System.out.println(o.isPossible(new int[]{1, 2, 3, 4, 4, 5}));
    }

}
