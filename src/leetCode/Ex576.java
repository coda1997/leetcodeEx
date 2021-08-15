package leetCode;

public class Ex576 {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int mod = 1000000007;
        int[][] offset = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int res = 0;
        int[][][] dp = new int[maxMove + 1][m][n];
        dp[0][startRow][startColumn] = 1;
        for (int i = 1; i < maxMove + 1; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    if (dp[i - 1][j][k] > 0) {
                        for (int l = 0; l < 4; l++) {
                            int x = j + offset[l][0];
                            int y = k + offset[l][1];
                            if (x >= 0 && x < m && y >= 0 && y < n) {
                                dp[i][x][y] = (dp[i][x][y] + dp[i - 1][j][k]) % mod;
                            } else {
                                res = (res + dp[i - 1][j][k]) % mod;
                            }
                        }
                    }
                }
            }
        }
        return res % mod;
    }

}
