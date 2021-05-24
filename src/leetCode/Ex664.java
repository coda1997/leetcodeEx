package leetCode;

public class Ex664 {
    public int strangePrinter(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        min = Math.min(dp[i][k] + dp[k + 1][j], min);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][len-1];
    }
}
