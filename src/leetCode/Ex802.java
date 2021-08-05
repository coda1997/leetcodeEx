package leetCode;

import java.util.ArrayList;

/**
 * Ex802
 */
public class Ex802 {
    private int n;
    private int[] isSafe;
    private int[][] graph;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        n = graph.length;
        this.graph = graph;
        var res = new ArrayList<Integer>();
        isSafe = new int[n];
        for (int i = 0; i < n; i++) {
            if(helper(i)){
                res.add(i);
            }
        }
        return res;
    }
    private boolean helper(int i){
        if(isSafe[i]==0){
            isSafe[i] = -1;
            for(int item : graph[i]){
                if(!helper(item)){
                    isSafe[i] = -1;
                    return false;
                }
            }
            isSafe[i] = 1;
            return true;
        }else{
            return isSafe[i] == 1;
        }
    }
}