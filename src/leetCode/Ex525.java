package leetCode;

import java.util.HashMap;

public class Ex525 {
    public int findMaxLength(int[] nums) {
        int res = 0;
        int sum = 0;
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return res;
    }
}
