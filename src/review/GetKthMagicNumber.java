package review;

public class GetKthMagicNumber {
    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int i3 = 0, i5 = 0,i7=0;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(dp[i3]*3, Math.min(dp[i5]*5, dp[i7]*7));
            if (dp[i] == dp[i3]*3){
                i3++;
            }
            if (dp[i] == dp[i5]*5){
                i5++;
            }
            if (dp[i] == dp[i7]*7){
                i7++;
            }
        }
        return dp[k-1];
    }
}
