package leetCode;

import java.util.HashMap;

public class Ex1442 {
    public int countTriplets(int[] arr) {
        int res = 0;
        int temp = 0;
        var countMap = new HashMap<Integer, Integer>();
        var totalMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (countMap.containsKey(temp ^ val)) {
                res += countMap.get(temp ^ val) * i - totalMap.get(temp ^ val);
            }
            countMap.put(temp, countMap.getOrDefault(temp, 0) + 1);
            totalMap.put(temp, totalMap.getOrDefault(temp, 0) + i);
            temp ^= val;
        }
        return res;
    }
}
