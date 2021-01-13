package leetCode;

import java.util.Arrays;

public class Ex684 {
    public int[] findRedundantConnection(int[][] edges) {
        int nodes = edges.length;
        int[] parents = new int[nodes+1];
        for (int i = 0; i < nodes; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            if (find(parents, edge[0]) == find(parents, edge[1])) {
                return edge;
            }
            union(parents, edge[0], edge[1]);
        }


        return new int[0];
    }

    private int find(int[] parents, int i) {
        if (parents[i] != i) {
            parents[i] = find(parents, parents[i]);
        }
        return parents[i];
    }

    private void union(int[] parents, int i, int j){
        parents[find(parents, i)] = find(parents, j);
    }

    public static void main(String[] args) {
        var o = new Ex684();
        int[] res = o.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
        System.out.println(Arrays.toString(res));
    }
}
