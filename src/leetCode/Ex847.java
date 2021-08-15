package leetCode;

import java.util.Arrays;

public class Ex847 {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], n + 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                dist[i][graph[i][j]] = 1;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int mask = 1; mask < (1 << n); mask++) {
            if ((mask & (mask - 1)) == 0) {
                int u = Integer.bitCount((mask & (-mask)) - 1);
                dp[u][mask] = 0;
            } else {
                for (int u = 0; u < n; u++) {
                    if ((mask & (1 << u)) != 0) {
                        for (int v = 0; v < n; v++) {
                            if ((mask & (1 << v)) != 0 && u != v) {
                                dp[u][mask] = Math.min(dp[u][mask], dp[v][mask ^ (1 << u)] + dist[u][v]);
                            }
                        }

                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[i][(1<<n)-1]);
        }
        return res;
    }


}
