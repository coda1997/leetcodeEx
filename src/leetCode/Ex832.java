package leetCode;

public class Ex832 {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0;i<A.length;i++){
            int len = A[i].length;
            for(int j = 0;j<len/2;j++){
                //swap A[i][j] and A[i][l-j]
                //and flip bit
                int t = A[i][j];
                A[i][j] = A[i][len-j-1] ^ 1;
                A[i][len-j-1] = t ^ 1;
            }
            // odd case, the middle one shoud be fliped
            if(len%2!=0){
                A[i][len/2] ^= 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        var o = new Ex832();
        o.flipAndInvertImage(new int[][]{{1,1,0},{0,0,1},{0,0,0}});
    }
}
