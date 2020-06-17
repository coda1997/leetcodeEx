package course;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PartitionPalindrome {
    private int[][] isPalindrome;
    public List<List<String>> partition(String s) {
        var cc = s.toCharArray();
        var res = new LinkedList<List<String>>();
        Deque<String> stack = new ArrayDeque<>();
        isPalindrome = new int[cc.length][cc.length];
        backtrace(s, 0, cc.length, stack, res);
        return res;
    }

    private void backtrace(String s, int start, int end, Deque<String> stack, List<List<String>> res){
        if(start==end){
            res.add(new ArrayList<>(stack));
        }
        for (int i = start+1; i <= end; i++) {
            var temp = s.substring(start, i);
            if(checkPalindrome(s,start,i-1)){
                stack.addLast(temp);
                backtrace(s, i, end, stack, res);
                stack.removeLast();
            }
        }
    }
    private int checkPalindrome(String s){
        var cc = s.toCharArray();
        int i = 0;
        int j = cc.length-1;
        while(i<j){
            if(cc[i]!=cc[j]){
                return -1;
            }
            i++;
            j--;
        }
        return 1;
    }
    private boolean checkPalindrome(String s,int i, int j){
        if(isPalindrome[i][j]==0){
            isPalindrome[i][j]=checkPalindrome(s.substring(i,j+1));
        }
        return isPalindrome[i][j]==1;
    }
}