package leetCode;
import java.util.List;
import java.util.ArrayList;

public class Ex834 {
    int[] res;
    int[] dp;
    int[] sz;
    List<List<Integer>> edges = new ArrayList<>();
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        res = new int[N];
        dp = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            this.edges.add(new ArrayList<>());
        }

        for (int[] ss : edges) {
            this.edges.get(ss[0]).add(ss[1]);
            this.edges.get(ss[1]).add(ss[0]);
        }

        dfs1(0, -1);
        dfs2(0, -1);
        return res;
    }

    private void dfs1(int u, int r){
        dp[u] = 0;
        sz[u] = 1;
        for (int i : edges.get(u)) {
            if(i == r){
                continue;
            }
            dfs1(i, u);
            dp[u]+= dp[i]+sz[i];
            sz[u]+= sz[i];
        }
    }
    private void dfs2(int u, int r){
        res[u] = dp[u];
        for (int v : edges.get(u)) {
            if(v==r){
                continue;
            }
            int dpu = dp[u], dpv = dp[v];
            int szu = sz[u], szv = sz[v];

            dp[u] = dp[u] - dp[v]-sz[v];
            sz[u] = sz[u] - sz[v];
            dp[v] = dp[v] + dp[u] +sz[u];
            sz[v] = sz[v] + sz[u];

            dfs2(v, u);

            dp[u] = dpu;
            dp[v] = dpv;
            sz[u] = szu;
            sz[v] = szv;
        }
    }
}
