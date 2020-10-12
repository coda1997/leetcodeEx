package leetCode;

public class Ex416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if(nums.length<2||sum%2!=0){
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        if(nums[0]<=target){
            dp[nums[0]] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j > 0; j--) {
                if(nums[i] <= j){
                    dp[j]=dp[j]||dp[j-nums[i]];
                }
            }
            if(dp[target]){
                return true;
            }
        }
        return dp[target];
    }
}
