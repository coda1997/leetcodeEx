package course;

import java.util.ArrayList;
import java.util.List;
/**
 * Leetcode 310
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。
 * 图因此可以成为树，在所有可能的树中，具有最小高度的树被称为最小高度树。
 * 给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 */
public class FindMinHeightTrees {
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degrees = new int[n];
        ArrayList<Integer>[] passs = new ArrayList[n];

        for (int[] e : edges) {
            degrees[e[0]]++;
            degrees[e[1]]++;
            if(passs[e[0]]==null){
                passs[e[0]] = new ArrayList<Integer>();
            }
            passs[e[0]].add(e[1]);
            if(passs[e[1]]==null){
                passs[e[1]] = new ArrayList<Integer>();
            }
            passs[e[1]].add(e[0]);
        }
        var res = new ArrayList<Integer>();
        var r = n;
        while(r>0){
            res.clear();
            for (int i = 0; i < n; i++) {
                if(degrees[i]==1||degrees[i]==0){
                    res.add(i);
                    r--;
                    degrees[i]=-1;
                }
                
            }
            for (Integer item : res) {
                if(passs[item]==null){
                    continue;
                }
                for (int i = 0; i < passs[item].size(); i++) {
                    degrees[passs[item].get(i)]--;
                    
                }
            }
        }
        return res;
    }
    

}