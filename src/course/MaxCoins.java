package course;

public class MaxCoins {
    public int maxCoins(int[] nums) {
        var dp = new int[nums.length + 2][nums.length + 2];
        var values = new int[nums.length + 2];
        values[0] = values[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            values[i + 1] = nums[i];
        }
        for (int i = dp.length-3; i >=0; i--) {
            for (int j = i+2; j < dp[i].length; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
                }

            }
        }
        return dp[0][dp.length - 1];
    }
}