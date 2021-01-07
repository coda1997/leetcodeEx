package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Ex547 {
    public int findCircleNum(int[][] isConnected) {
        //bfs
        int len = isConnected.length;
        int res = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if (isConnected[i][i] == 0) {
                continue;
            }
            res++;
            queue.offer(i);
            while (!queue.isEmpty()) {
                var ii = queue.poll();
                isConnected[ii][ii] = 0;
                for (int j = 0; j < len; j++) {
                    if (isConnected[ii][j] == 1) {
                        queue.offer(j);
                        isConnected[ii][j] = isConnected[j][ii] = 0;
                    }
                }
            }

        }

        return res;
    }

    public int findCircleNum2(int[][] isConnected){
        int len = isConnected.length;
        int[] parents = new int[len];
        for (int i = 0; i < len; i++) {
            parents[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(isConnected[i][j]==1){
                    union(parents, i, j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if(parents[i]==i){
                res++;
            }
        }
        return res;
    }


    private int find(int[] parent, int index){
        if (parent[index] != index){
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    private void union(int[] parent, int i, int j){
        parent[find(parent, i)] = find(parent, j);
    }


    public static void main(String[] args) {
        var o = new Ex547();
        System.out.println(o.findCircleNum2(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(o.findCircleNum2(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
