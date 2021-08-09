package leetCode;

public class Ex313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        dp[0] = 1;
        int[] pointer = new int[primes.length];

        for (int i = 1; i <n; i++) {
            int min = Integer.MAX_VALUE;
            int[] nums = new int[primes.length];
            for (int j = 0; j < primes.length; j++) {
                nums[j] = dp[pointer[j]] * primes[j];
                min = Math.min(min, nums[j]);
            }
            dp[i] = min;
            for (int j = 0; j < primes.length; j++) {
                if (min == nums[j]){
                    pointer[j]++;
                }
            }
        }
        return dp[n-1];
    }
}
