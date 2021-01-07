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

    public static void main(String[] args) {
        var o = new Ex547();
        System.out.println(o.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}));
        System.out.println(o.findCircleNum(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }
}
