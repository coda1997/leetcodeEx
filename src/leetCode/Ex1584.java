package leetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex1584 {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                edges.add(new Edge(distance(points, i, j), i, j));
            }
        }
        edges.sort(Comparator.comparingInt(o -> o.len));
        var unionFind = new UnionFind(len);
        int res = 0; int num = 0;
        for (var edge :
                edges) {
            if(unionFind.union(edge.i,edge.j)){
                res+=edge.len;
                num++;
            }
            if (num==len){
                break;
            }
        }

        return res;
    }

    private int distance(int[][] points, int i, int j){
        return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
    }

    class Edge{
        int len;
        int i, j;
        Edge(int len, int i, int j){
            this.len = len;
            this.i = i;
            this.j = j;

        }

    }

    class UnionFind{
        int[] parents;
        UnionFind(int n){
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public int find(int i){
            return i==parents[i] ? i: (parents[i]=find(parents[i]));
        }

        public boolean union(int i, int j){
            int rootI = find(i);
            int rootJ = find(j);
            if(rootI==rootJ) {
                return false;

            }
            parents[rootI] = parents[rootJ];//equal to parents[rootI] = rootJ
            return true;
        }
    }
}
