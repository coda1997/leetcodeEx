package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Ex90 {
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> temp = new LinkedList<>();
    private List<int[]> ts = new ArrayList<>();
    private int len;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(i==0||nums[i]!=ts.get(ts.size()-1)[0]){
                ts.add(new int[]{nums[i],1});
            }else{
                ts.get(ts.size()-1)[1]++;
            }
        }
        len = ts.size();
        helper(0);
        return res;
    }

    private void helper(int i){
        if(i==len){
            res.add(new ArrayList<>(temp));
            return;
        }
        helper(i+1);
        var tt = ts.get(i);
        var item = tt[0];
        var c = tt[1];
        for (int j = 0; j < c; j++) {
            temp.push(item);
            helper(i+1);
        }
        for (int j = 0; j < c; j++) {
            temp.pop();
        }
    }
}
