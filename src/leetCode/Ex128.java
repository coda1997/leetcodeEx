package leetCode;

import java.util.HashMap;

public class Ex128 {
    public int longestConsecutive(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num,1);
            }
        }

        int res=0;
        for (int num : nums) {
            int t = 1;
            int i = num+1;
            int j = num-1;
            if (!map.containsKey(num)){
                continue;
            }
            while (map.containsKey(i)){
                map.remove(i++);
                t++;
            }
            while (map.containsKey(j)) {
                map.remove(j--);
                t++;
            }
            res= t>res?t:res;
        }

        return res;
    }
}
