package leetCode;

public class Ex463 {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int n = grid.length;
        if(n==0){
            return res;
        }
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1){
                    if(i==0||grid[i-1][j]==0){
                        res++;
                    }
                    if(i==n-1||grid[i+1][j]==0){
                        res++;
                    }
                    if(j==0||grid[i][j-1]==0){
                        res++;
                    }
                    if(j==m-1||grid[i][j+1]==0){
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
