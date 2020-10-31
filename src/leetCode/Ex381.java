package leetCode;

import java.util.*;

public class Ex381 {
    Map<Integer, Set<Integer>> map;
    ArrayList<Integer> nums;

    /** Initialize your data structure here. */
    public Ex381() {
        map = new HashMap<>();
        nums = new ArrayList<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not
     * already contain the specified element.
     */
    public boolean insert(int val) {
        var set = map.getOrDefault(val, new HashSet<>());
        var l = set.size();
        set.add(nums.size());
        nums.add(val);
        map.put(val, set);
        return l == 0;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained
     * the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        var set = map.get(val);
        var lastNum = nums.get(nums.size()-1);
        var index = set.iterator().next();
        nums.set(index, lastNum);
        set.remove(index);
        map.get(lastNum).remove(nums.size()-1);
        if(index<nums.size()-1){
            map.get(lastNum).add(index);
        }
        if (set.isEmpty()) {
            map.remove(val);
        }
        nums.remove(nums.size()-1);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get((int)(Math.random()*nums.size()));
    }

    public static void main(String[] args) {
        var o = new Ex381();
        o.insert(0);
        o.insert(1);
        o.insert(0);
        o.remove(0);
        System.out.println(o.remove(0));
    }
}
