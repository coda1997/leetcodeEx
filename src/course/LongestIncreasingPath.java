package course;



public class LongestIncreasingPath {
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res = Math.max(res, findDepth(matrix, i, j));
            }
        }
        return res;
    }
    private int findDepth(int[][] matrix, int i, int j){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        int temp = 1;
        if(i-1>=0&&matrix[i][j]>matrix[i-1][j]){
            temp = Math.max(temp, findDepth(matrix, i-1, j)+1);
        }
        if(i+1<matrix.length&&matrix[i][j]>matrix[i+1][j]){
            temp = Math.max(temp, findDepth(matrix, i+1, j)+1);
        }
        if(j-1>=0&&matrix[i][j]>matrix[i][j-1]){
            temp = Math.max(temp, findDepth(matrix, i, j-1)+1);
        }
        if(j+1<matrix[i].length&&matrix[i][j]>matrix[i][j+1]){
            temp = Math.max(temp, findDepth(matrix, i, j+1)+1);
        }
        dp[i][j] = temp;
        return temp;
    }
    public static void main(String[] args) {
        var o  = new LongestIncreasingPath();
        o.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}});
    }
}