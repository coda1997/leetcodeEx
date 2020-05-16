package course;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int h = len/2;
        for(int i = 0;i<h;i++){
            for(int j = i;j<len-i-1;j++){
                helper(matrix, i, j, h);
            }
        }
        
    }
    
    private void helper(int[][] matrix, int i, int j, int h){
        //when the length is even, there is an offset;
        int offset = 0;
        if(matrix.length%2==0){
            offset = 1;
        }
        int m = j;
        int n = 2*h-i-offset;
        int item = matrix[m][n];
        matrix[m][n] = matrix[i][j];//one
        i = n;
        j = 2*h-m-offset;
        int temp = matrix[i][j];
        matrix[i][j] = item;//two
        m = j;
        n = 2*h-i-offset;
        item = matrix[m][n];
        matrix[m][n] = temp;//three;
        i = n;
        j = 2*h-m-offset;
        matrix[i][j] = item;//four;
    }

    public static void main(String[] args) {
        var i = new RotateMatrix();
        i.rotate(new int[][]{new int[]{1,2,3}, new int[]{4,5,6},new int[]{7,8,9}});
    }
}