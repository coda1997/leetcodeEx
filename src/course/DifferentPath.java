package course;

public class DifferentPath {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0){
            return 0;
        }

        int[] dp = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if(obstacleGrid[i][j]==0){
                    if(j>0){
                        dp[j] = dp[j] + dp[j-1];
                    }else{
                        if(i==0){
                            dp[j] = 1;
                        }
                    }
                }else{
                    dp[j] = 0;
                }
            }
        }
        return dp[obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        var o = new DifferentPath();
        System.out.println(o.uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(o.uniquePathsWithObstacles(new int[][]{{1,0}}));
        System.out.println(o.uniquePathsWithObstacles(new int[][]{{0}}));
    }
}