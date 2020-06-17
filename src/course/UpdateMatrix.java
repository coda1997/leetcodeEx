package course;


public class UpdateMatrix {
    

    public int[][] updateMatrix(int[][] matrix) {
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    // find the nearest zero loc
                    boolean[][] visited = new boolean[matrix.length][matrix[i].length];
                    matrix[i][j] = helper(matrix, i,j,visited);
                }
            }
        }
        return matrix;
    }
    private int helper(int[][] matrix, int i, int j,boolean[][] visited) {
        int depth = Integer.MAX_VALUE;
        visited[i][j] = true;
        if(matrix[i][j]==0){
            return 0;
        }
        if(matrix[i][j]>1){
            return matrix[i][j];
        }
        for (int k = -1; k <=1; k+=2) {
            if(i+k>=0&&i+k<matrix.length&&!visited[i+k][j]){
                int t = helper(matrix, i+k, j,visited)+1;
                depth = depth<t?depth:t;
            }
            if(j+k>=0&&j+k<matrix[i].length&&!visited[i][j+k]){
                int t = helper(matrix, i, j+k,visited)+1;
                depth = depth<t?depth:t;
            }
        }
        return depth==Integer.MAX_VALUE?0:depth;

    }
    public static void main(String[] args) {
        new UpdateMatrix().updateMatrix(new int[][]{{0,0,0},{1,1,1},{1,0,1}});
    }
}