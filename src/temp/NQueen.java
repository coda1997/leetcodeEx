package temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueen {
    private List<List<String>> res;
    private boolean[] cols;
    private boolean[] rl;
    private boolean[] rr;
    private List<String> temp;
    private boolean[] rows;
    private char[] tt;
    private int offset;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        cols = new boolean[n];
        rows = new boolean[n];
        rl = new boolean[2*n-1];
        rr = new boolean[rl.length];
        tt = new char[n];
        Arrays.fill(tt, '.');
        temp = new ArrayList<>();
        offset = n-1;
        helper(0,0, n);
        return res;
    }

    private void helper(int i, int j, int n){
        if (n==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        if (i>= rows.length||j>=cols.length){
            return;
        }        //is not valid
        if (rows[i]){

            helper(i+1, 0,n);
            return;
        }
        if (j==cols.length-1){
            helper(i+1, 0, n);
        }else{
            helper(i, j+1,n);
        }
        if (cols[j]||rl[j-i+offset]||rr[i+j]){
            return;
        }
        //set i, j, a queen
        tt[j] = 'Q';
        temp.add(new String(tt));
        tt[j] = '.';
        rows[i] = true;
        cols[j] = true;
        rl[j-i+offset] = true;
        rr[j+i] = true;
        helper(i+1, 0,n-1);
        temp.remove(temp.size()-1);
        rows[i] = false;
        cols[j] = false;
        rl[j-i+offset] = false;
        rr[j+i] = false;
    }

    public static void main(String[] args) {
        var o = new NQueen();
        var res = o.solveNQueens(4);
        res.forEach((item)->item.forEach(System.out::println));
    }
}
