package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex216 {
    private List<List<Integer>> res  = new ArrayList<>();
    private ArrayList<Integer> temp = new ArrayList<>();
    int max = 45;
    int k;
    int n;
    public List<List<Integer>> combinationSum3(int k, int n) {
        max = max/k;
        this.k = k;
        this.n = n;
        helper(1, 0);
        return res;
    }

    private void helper(int i, int value){
        if(value == n&&temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        if(temp.size()>=k){
            return;
        }
        if(i==10){
            return;
        }
        helper(i+1, value);
        temp.add(i);
        helper(i+1, value+i);
        temp.remove(temp.size()-1);
    }
}
