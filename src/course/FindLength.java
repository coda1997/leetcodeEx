package course;

public class FindLength {
    
    public int findLength(int[] A, int[] B) {
        //dp to solve it
        int[][] dp = new int[A.length][B.length];
        int res = 0;
        for (int i = dp.length-1; i >=0; i--) {
            for (int j = dp[i].length-1; j >=0; j--) {
                if(A[i]==B[j]){
                    if(i==dp.length-1||j==dp.length-1){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=dp[i+1][j+1]+1;
                    }
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }

    
}