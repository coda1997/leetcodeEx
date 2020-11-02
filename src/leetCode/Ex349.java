package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Ex349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int item: nums1){
            set.add(item);
        }
        var res = new ArrayList<Integer>();
        for(int item: nums2){
            if(set.contains(item)){
                res.add(item);
                set.remove(item);
            }
        }
        int[] r = new int[res.size()];
        int i = 0;
        var itor = res.iterator();
        while(itor.hasNext()){
            r[i++] = itor.next();
        }
        return r;
    }
}
