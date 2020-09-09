package leetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Ex39 {
    private List<List<Integer>> res;
    private Deque<Integer> temp;
    private int t;
    private int[] cs;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        temp = new LinkedList<>();
        t = target;
        cs = candidates;
        helper(0, 0);
        return res;
    }

    private void helper(int i, int cur){
        if(cur==t){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(i==cs.length){
            return;
        }
        int j;
        for (j = 0; cur+cs[i]*j<=t; j++) {
            if(j>0){
                temp.push(cs[i]);
            }
            helper(i+1, cur+cs[i]*j);
        }
        for (int j2 = 1; j2 < j; j2++) {
            temp.pop();
        }
    }
}
