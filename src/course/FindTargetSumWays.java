package course;

public class FindTargetSumWays {

    public int findTargetSumWays(int[] nums, int S) {
        return helper(nums, S, 0, 0);
    }
    private int helper(int[] nums, int S, int start,int now){
        if(start>=nums.length){
            if(S==now){
                return 1;
            }else{
                return 0;
            }
        }
        return helper(nums, S, start+1, now+nums[start])+helper(nums, S, start+1, now-nums[start]);
        
    }
}