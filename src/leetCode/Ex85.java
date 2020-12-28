package leetCode;

public class Ex85 {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        if (matrix.length < 1) {
            return res;
        }
        int[][] space = new int[matrix.length][matrix[0].length];
        //add the row
        for (int i = 0; i < matrix.length; i++) {
            space[i][0] = matrix[i][0]-'0';
            for (int j = 1; j < matrix[i].length; j++) {
                if(matrix[i][j]=='1'){
                    space[i][j] = space[i][j-1]+matrix[i][j]-'0';
                }
            }
        }

        //add the column
        for (int col = 0; col < space[0].length; col++) {
            for (int row = space.length-1; row > 0; row--) {
                int max = space[row][col];
                for (int i = row-1; i>=0 ; i--) {
                    if(space[i][col]==0){
                        break;
                    }
                    max = Math.min(space[i][col], max);
                    space[row][col] = Math.max(space[row][col], (row-i+1)*max);
                }
            }
        }

        //to find the max space;
        for (int[] ints : space) {
            for (int item : ints) {
                res = Math.max(res, item);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Ex85();
        System.out.println(o.maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
        System.out.println(o.maximalRectangle(new char[][]{{'0'}}));
        System.out.println(o.maximalRectangle(new char[][]{{'1'}}));
        var c = new char[][]{{'1','0','1','1','1'},{'0','1','0','1','0'},{'1','1','0','1','1'},{'1','1','0','1','1'},{'0','1','1','1','1'}};
        System.out.println(o.maximalRectangle(c));
    }
}
