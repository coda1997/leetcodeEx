package course;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++){
            var temp = target- nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }else{
                map.put(nums[i], i);
            }
        }
        return null;
    }
}