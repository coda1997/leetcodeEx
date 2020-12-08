package leetCode;

public class Ex861 {
    public int matrixScore(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                for (int j = 0; j < A[i].length; j++) {
                    A[i][j] ^= 1;
                }
            }
        }
        //then all the headers are 1s.
        //flip the remains, keeping all digit are almost Ones.
        for (int col = 1; col < A[0].length; col++) {
            int c = 0;
            for (int[] ints : A) {
                c += ints[col];
            }
            if (c <= A.length / 2) {
                for (int row = 0; row < A.length; row++) {
                    A[row][col] ^= 1;
                }
            }
        }
        int res = 0;
        for(int[] item : A){
            int t= 0;
            for (int j : item) {
                t = t * 2 + j;
            }
            res+=t;
        }
        return res;
    }
}
