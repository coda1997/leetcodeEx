package leetCode;

import java.util.HashMap;

/**
 * 给定一个整数数组和一个整数 k， 判断数组中是否存在两个不同的索引 i 和 j， 使得 nums [i] = nums [j]，并且 i 和 j 的差的
 * 绝对值 至多为 k
 */
public class Ex219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var item = nums[i];
            if (map.containsKey(item) && i - map.get(item) <= k) {
                return true;
            }
            map.put(item, i);
        }
        return false;
    }
}