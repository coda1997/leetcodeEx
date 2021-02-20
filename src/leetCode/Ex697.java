package leetCode;

import java.util.HashMap;

public class Ex697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer[]> map = new HashMap<>();
        //1st loop for initializing the hashmap;
        for(int i = 0;i<nums.length;i++){
            var vs = map.getOrDefault(nums[i], new Integer[]{0, i, i});
            vs[0]++;
            vs[2] = i;
            map.put(nums[i], vs);
        }
        int max = -1;
        int res = nums.length;
        //then find the degree and the corresponding length;
        for(var key : map.keySet()){
            var vs = map.get(key);
            if(vs[0]>max){
                res = vs[2]-vs[1]+1;
                max = vs[0];
            }else if (vs[0]==max){
                res = Math.min(vs[2]-vs[1]+1, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Ex697();
        System.out.println(o.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
