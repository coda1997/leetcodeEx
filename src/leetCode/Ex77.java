package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex77 {
    private List<List<Integer>> res;
    private List<Integer> temp;
    int len;
    int N;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        temp = new ArrayList<>();
        len = k;
        N = n;
        helper(1, 0);
        return res;
    }

    private void helper(int i, int k){
        if(N-i+1<k-temp.size()){
            return;
        }
        
        if(k == len){
            res.add(new ArrayList<>(temp));
            return;
        }
        // i not been chosen
        helper(i+1, k);
        temp.add(i);
        helper(i+1, k+1);
        temp.remove(temp.size()-1);
    }

    public static void main(String[] args) {
        var o = new Ex77();
        var t = o.combine(4, 2);
        for (List<Integer> list : t) {
            System.out.println(list.toString());
        }
    }
}
