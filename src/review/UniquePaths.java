package review;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        int[] dp = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 0) {
                dp[i] = 1;
            } else {
                dp[i] = 0;
                break;
            }
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    if (j > 0) {
                        dp[j] = dp[j - 1] + dp[j];
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }

    private int res = 0;
    private int tr, tc;
    private int[][] grid;

    public int uniquePathsIII(int[][] grid) {
        int sr = 0, sc = 0;
        int todo = 2;
        rowLen = grid.length;
        if (rowLen == 0) {
            return res;
        }
        this.grid = grid;
        colLen = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                } else if (grid[i][j] == 2) {
                    tr = i;
                    tc = j;
                } else if (grid[i][j] == 0) {
                    todo++;
                }
            }
        }

        dfs(sr, sc, todo);
        return res;
    }

    private int[][] offset = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int rowLen, colLen;

    private void dfs(int sr, int sc, int todo) {
        todo--;
        if (todo < 0) {
            return;
        }
        if (sr == tr && sc == tc) {
            if (todo == 0) {
                res++;
            }
            return;
        }
        int t = grid[sr][sc];
        grid[sr][sc] = -1;
        for (int i = 0; i < 4; i++) {
            int tempR = sr + offset[i][0];
            int tempC = sc + offset[i][1];
            if (tempR >= 0 && tempR < rowLen && tempC >= 0 && tempC < colLen && grid[tempR][tempC] != -1) {
                dfs(tempR, tempC, todo);
            }
        }
        grid[sr][sc] = t;

    }
}
