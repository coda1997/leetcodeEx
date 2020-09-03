package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex51 {
    private List<List<String>> res = new ArrayList<List<String>>();
    private int t3 = 0, t1 = 0, t2 = 0;

    public List<List<String>> solveNQueens(int n) {
        var t = new ArrayList<String>();
        ct = new char[n];
        Arrays.fill(ct, '.');
        helper(t, 0, n);
        return res;
    }   
    private char[] ct;
    private void helper(List<String> temp, int r, int n){
        if(r==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if(isVaild(r, i, n)){
                t3 |= 1<<i;
                t2 |= 1<<(i+r);
                t1 |= 1<<(i-r+n);
                ct[i] = 'Q';
                String t = String.valueOf(ct);
                ct[i]  = '.';
                temp.add(t);
                helper(temp, r+1, n);
                temp.remove(t);
                t3 ^= 1<<i;
                t2 ^= 1<<(i+r);
                t1 ^= 1<<(i-r+n);
            }
        }

    }
    private boolean isVaild(int r,int c, int n){
        if((1<<c&t3) ==0 &&(1<<(c+r)&t2)==0&&(1<<(c-r+n)&t1)==0){
            return true;
        }
        return false;
    }
}


