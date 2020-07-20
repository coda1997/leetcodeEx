package course;

import java.util.HashMap;

public class TwoSumTwo {
    public int[] twoSum(int[] numbers, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            var item = numbers[i];
            if(map.containsKey(item)){
                int l = map.get(item);
                return new int[]{l+1, i+1};
            }else{
                map.put(target-item, i);
            }
        }
        return null;
    }
}