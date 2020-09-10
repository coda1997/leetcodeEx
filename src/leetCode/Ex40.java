package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Ex40 {
    private ArrayList<int[]> times;
    private List<List<Integer>> res;
    private Deque<Integer> stack;
    private int t;
    private int len;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        times = new ArrayList<>();
        res = new ArrayList<>();
        stack = new LinkedList<>();
        t = target;
        Arrays.sort(candidates);
        for (int i : candidates) {
            var len = times.size();
            if(times.isEmpty()||i!=times.get(len-1)[0]){
                times.add(new int[]{i, 1});
            }else{
                times.get(len-1)[1]++;
            }
        }
        len = times.size();
        helper(0, 0);
        return res;
    }

    private void helper(int temp, int i){
        
        if(temp==t){
            res.add(new ArrayList<>(stack));
            return;
        }
        if(i==len){
            return;
        }
        var tt = times.get(i);
        var item = tt[0];
        var ts = tt[1];
        int j;
        helper(temp, i+1);
        for (j = 1; j <= ts&&temp+item*j<=t; j++) {
            stack.push(item);
            helper(temp+item*j, i+1);
        }
        for (int k = 0; k < j-1; k++) {
            stack.pop();
        }
    }

}
