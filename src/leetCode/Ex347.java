package leetCode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 */
public class Ex347 {
    public int[] topKFrequent(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        ArrayList<Integer>[] t = new ArrayList[nums.length+1];
        for(int key : map.keySet()){
            var item = map.get(key);
            if(t[item]==null){
                t[item] = new ArrayList<Integer>();
            }
            t[item].add(key);
        }
        var res = new int[k];
        for (int i = nums.length; i >=0; i--) {
            if(t[i]!=null){
                for (int item : t[i]) {
                    res[k-1] = item;
                    k--;
                    if(k==0){
                        break;
                    }
                }
                if(k==0){
                    break;
                }
            }
        }
        return res;
    }
    
}