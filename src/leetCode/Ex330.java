package leetCode;

public class Ex330 {
    public int minPatches(int[] nums, int n) {
        int patch = 0;
        int index = 0;
        long x = 1;
        while (x<=n){
            if(index<nums.length&&nums[index]<=x){
                x += nums[index];
                index++;
            }else {
                x *= 2;
                patch++;
            }
        }
        return patch;
    }
}
