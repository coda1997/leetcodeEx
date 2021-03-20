package leetCode;

public class Ex1579 {
    class UnionFind {
        int[] parents;

        UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        int find(int i) {
            if (parents[i] != i) {
                parents[i] = find(parents[i]);
            }
            return parents[i];
        }

        //if i and j have already union, it returns true.
        //Otherwise, it returns false.
        boolean union(int i, int j) {
            int pI = find(i);
            int pJ = find(j);
            if (pI == pJ) {
                return true;
            }
            parents[pI] = pJ;
            return false;
        }
        boolean check(){
            int p = find(0);
            for (int i = 1; i < parents.length; i++) {
                if (p != find(i)) {
                    return false;
                }
            }
            return true;
        }

    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if (n<2){
            return edges.length;
        }
        UnionFind a = new UnionFind(n);
        UnionFind b = new UnionFind(n);
        int res = 0;
        //the index of unionfind is different from the graph.
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                var r1 = a.union(edge[1]-1, edge[2]-1);
                var r2 = b.union(edge[1]-1, edge[2]-1);
                if (r1&&r2){
                    res++;
                }
            }
        }
        for (int[] edge :
                edges) {
            if (edge[0] == 3) {
                continue;
            }
            if (edge[0]==1){
                if (a.union(edge[1]-1, edge[2]-1)){
                    res++;
                }
            }
            if (edge[0] ==2){
                if (b.union(edge[1]-1, edge[2]-1)){
                    res++;
                }
            }
        }
        //check whether all the nodes in the graph can be reached by alice and bob.
        //If not, return -1;
        if (a.check()&&b.check()){
            return res;
        }else{
            return -1;
        }
    }
}
