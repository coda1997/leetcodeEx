package leetCode;

public class Ex59 {
    public int[][] generateMatrix(int n) {
        int t = 0;
        int c=0,r = 0;
        int[][] res  = new int[n][n];
        int i =1;
        while (t<n/2){
            c=r=t;
            while (c + 1 < n - t){
                res[r][c++] = i++;
            }
            while (c+1==n-t&&r+1<n-t){
                res[r++][c] = i++;
            }
            while (c>t&&r+1==n-t){
                res[r][c--] = i++;
            }
            while (c==t&&r>t){
                res[r--][c]= i++;
            }
            t++;
        }
        if (n%2==1){
            res[n/2][n/2] = i;
        }


        return res;
    }

    public static void main(String[] args) {
        new Ex59().generateMatrix(5);
    }
}
