package leetCode;

public class Ex73 {
    public void setZeroes(int[][] matrix) {

        int r=-1,c=-1;

        for (int i = 0;i<matrix.length;i++){
            for (int j  = 0;j<matrix[i].length;j++){
                if (matrix[i][j]==0){
                   if (r == -1){
                       r=i;c=j;
                   }else {
                       matrix[r][j]=0;
                       matrix[i][c]=0;
                   }

                }
            }
        }
        if (r==-1) return;
        for (int i = 0;i<matrix[r].length;i++){
            if (i!=c&&matrix[r][i]==0){
                for (int j = 0;j<matrix.length;j++){
                    matrix[j][i]=0;
                }
            }
        }
        for (int i = 0;i<matrix.length;i++){
            if (matrix[i][c]==0){
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }

        }
        for (int i = 0;i<matrix.length;i++){
            matrix[i][c]=0;
        }


    }

    public static void main(String[] args) {
        Ex73 ex73 = new Ex73();
        int[][] t = new int[][]{{1,1,1},{0,1,2}};
        ex73.setZeroes(t);
        System.out.println(t[0][0]);
    }
}
