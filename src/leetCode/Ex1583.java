package leetCode;

public class Ex1583 {
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] pf = new int[n][n];
        int[] matches = new int[n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                pf[i][preferences[i][j]] = j;
            }
        }
        for (int[] pair :
                pairs) {
            matches[pair[0]] = pair[1];
            matches[pair[1]] = pair[0];
        }
        int res = 0;
        //loop from 0 to n-1
        for (int x = 0; x < n; x++) {
            int y = matches[x];
            int index = pf[x][y];
            for (int i = 0; i < index - 1; i++) {
                int u = preferences[x][i];
                int v = matches[u];
                if (pf[u][x] < pf[u][v]) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
