package review;

import java.util.*;

public class FrogPosition {
    private List<Integer>[] map;
    public double frogPosition(int n, int[][] edges, int t, int target) {
        map = new List[n];
        map[0]=new ArrayList<>();
        for(int[] edge: edges){
            if (map[edge[0]-1]!=null) {
                map[edge[0]-1].add(edge[1]);
            }else{
                var temp = new ArrayList<Integer>();
                temp.add(edge[1]);
                map[edge[0]-1]=temp;
            }
            if (map[edge[1]-1]!=null) {
                map[edge[1]-1].add(edge[0]);
            }else{
                var temp = new ArrayList<Integer>();
                temp.add(edge[0]);
                map[edge[1]-1]=temp;
            }
        }
        var chain = new LinkedList<Integer>();
        dfs(chain, target, 1,-1);
        int len = chain.size()-1;
        if (t<len){
            return 0;
        }
        if (!isLeaf(target)) {
            if (t>len){
                return 0;
            }
        }
        int temp = 1;
        for (int i = 0; i < chain.size() - 1; i++) {
            temp *= getChildNum(chain.get(i));
        }
        return 1.0/temp;
    }
    private int getChildNum(int target){
        return map[target-1].size()-(target==1?0:1);
    }
    private boolean isLeaf(int target){
        if (target==1){
            return map[target-1].size()==0;
        }else{
            return map[target-1].size()==1;
        }
    }

    private boolean dfs(LinkedList<Integer> chain, int target, int root, int p){
        if (target==root){
            chain.addLast(target);
            return true;
        }
        var t = false;
        for (var item :
                map[root-1]) {
            if (item!=p){
                if(dfs(chain, target, item, root)){
                    chain.addFirst(root);
                    return true;
                }
            }
        }
        return false;
    }
}
