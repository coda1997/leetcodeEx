package course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MininalSteps {
    int m, n;

    /*
     * 第一步，先进行初始化，拿到S，T，M，O的位置 
     * 第二步，判断边界条件，即M==0的情况，退化成S to T 
     * 第三步，计算S 到
     * O，O到M，M到O以及M到T的距离 
     * 第四步，合并S到M，M到M'以及M到T，消除O的中间状态 
     * 第五步，退化到最短路径问题
     */
    public int minimalSteps(String[] maze) {
        // step 1. to calculate s-> o for all o in the map.
        // also, o -> m, m->o, m->t
        // step 2. to obtain s->o->m, m->o->m' and m->t
        // step 3. use the shorest path al.

        if (maze.length == 0 || maze[0].length() == 0) {
            return 0;
        }
        m = maze.length;
        n = maze[0].length();

        var ms = new ArrayList<int[]>();
        var os = new ArrayList<int[]>();
        int[] s = new int[] { -1, -1 }, t = new int[] { -1, -1 };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char item = maze[i].charAt(j);
                if (item == 'S') {
                    s[0] = i;
                    s[1] = j;
                } else if (item == 'T') {
                    t[0] = i;
                    t[1] = j;
                } else if (item == 'M') {
                    ms.add(new int[] { i, j });
                } else if (item == 'O') {
                    os.add(new int[] { i, j });
                }
            }
        }
        int numM = ms.size();
        int numO = os.size();
        // calculate s->t for the corner case where numM==0;
        var ends = bfs(t[0], t[1], maze);
        if (numM == 0) {
            return ends[s[0]][s[1]];
        }

        int[][] dist = new int[numM][numM + 2];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], -1);
        }
        // before finding dist we need to obtain the mean state
        int[][][] temps = new int[numO][][];
        for (int i = 0; i < temps.length; i++) {
            var o = os.get(i);
            temps[i] = bfs(o[0], o[1], maze);
        }

        for (int i = 0; i < numM; i++) {
            var m1 = ms.get(i);
            // 1. m->s
            dist[i][numM] = getMinPathLen(m1, s, temps);
            // 2. m->t 不需要过O
            dist[i][numM + 1] = ends[m1[0]][m1[1]];
            // 3. m->m'
            for (int j = 0; j < numM; j++) {
                dist[i][j] = getMinPathLen(m1, ms.get(j), temps);
            }
        }
        // when the target is unreachable
        for (int[] d : dist) {
            if (d[numM] == -1 || d[numM + 1] == -1) {
                return -1;
            }
        }

        int[][] dp = new int[1 << numM][numM];
        for (int i = 0; i < 1 << numM; i++) {
            Arrays.fill(dp[i], -1);
        }
        // init s->m
        for (int i = 0; i < numM; i++) {
            dp[1 << i][i] = dist[i][numM];
        }

        for (int mask = 1; mask < (1 << numM); mask++) {
            for (int i = 0; i < numM; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < numM; j++) {
                        if ((mask & (1 << j)) == 0) {
                            int next = mask | (1 << j);
                            if (dp[next][j] == -1 || dp[next][j] > dp[mask][i] + dist[i][j]) {
                                dp[next][j] = dp[mask][i] + dist[i][j];
                            }
                        }
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        int mask = (1<<numM)-1;
        for (int i = 0; i < numM;i++) {
            if(res> dp[mask][i]+dist[i][numM+1]){
                res = dp[mask][i]+dist[i][numM+1];
            }
        }

        return res;
    }

    private int getMinPathLen(int[] s, int[] t, int[][][] temps) {
        int res = Integer.MAX_VALUE;
        for (int[][] dp : temps) {
            int tt = dp[s[0]][s[1]] + dp[t[0]][t[1]];
            if (tt>=0&& res > tt) {
                res = tt;
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }

    private int[][] bfs(int i, int j, String[] maze) {
        int[][] res = new int[m][n];
        for (int k = 0; k < res.length; k++) {
            Arrays.fill(res[k], -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { i, j });
        res[i][j] = 0;
        while (!queue.isEmpty()) {
            var item = queue.poll();
            for (int[] offset : state) {
                var x1 = item[0] + offset[0];
                var y1 = item[1] + offset[1];
                if (inBound(x1, y1) && maze[x1].charAt(y1) != '#' && res[x1][y1] == -1) {
                    queue.offer(new int[] { x1, y1 });
                    res[x1][y1] = res[item[0]][item[1]] + 1;
                }
            }
        }
        return res;

    }

    private int[][] state = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private boolean inBound(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }


    public static void main(String[] args) {
        var o = new MininalSteps();
        System.out.println(o.minimalSteps(new String[]{"S#O", "M.#", "M.T"}));
        System.out.println(o.minimalSteps(new String[]{"T#O", ".##", "O..", ".#.", "OSM", "#.."}));
    }
}