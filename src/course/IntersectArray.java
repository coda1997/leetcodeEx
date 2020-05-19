package course;

import java.util.HashMap;
import java.util.LinkedList;

public class IntersectArray {

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        var map = new HashMap<Integer,Integer>();
        for(var item: nums1){
            map.put(item, map.getOrDefault(item, 0)+1);
        }
        var res = new LinkedList<Integer>();
        for(var item: nums2){
            int count = map.getOrDefault(item, 0);
            if(count>0){
                res.add(item);
                map.put(item, count-1);
            }
        }
        var temp = new int[res.size()];
        var iterator = res.iterator();
        int i = 0;
        while(iterator.hasNext()){
            temp[i] = iterator.next();
            i++;
        }
        return temp;
    }
}