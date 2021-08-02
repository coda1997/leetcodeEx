package leetCode;

import java.util.Arrays;

public class Ex743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = Integer.MAX_VALUE / 2;
        int[][] w = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(w[i],INF);
        }
        for (var time :
                times) {
            int r = time[0] - 1;
            int c = time[1] - 1;
            w[r][c] = time[2];
        }
        int[] dis = new int[n];
        Arrays.fill(dis, INF);
        dis[k - 1] = 0;
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int j = 0; j < n; j++) {
                if (!used[j] && (x == -1 || dis[j] < dis[x])) {
                    x = j;
                }
            }
            used[x] = true;
            for (int j = 0; j < n; j++) {
                dis[j] = Math.min(dis[j], dis[x] + w[x][j]);
            }
        }
        int ret = Arrays.stream(dis).max().getAsInt();
        return ret == INF ? -1 : ret;
    }
}
