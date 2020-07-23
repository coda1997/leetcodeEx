package course;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            if(i==0){
                dp[i] = grid[0][i];
            }else{
                dp[i] = dp[i-1]+grid[0][i];
            }
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j > 0) {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                } else {

                    dp[j] += grid[i][j];

                }
            }
        }
        return dp[dp.length - 1];
    }
}