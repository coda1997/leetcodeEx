package leetCode;

public class Ex376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length<3){
            return nums.length;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>nums[i-1]){
                up = Math.max(up,down+1);
            }else if(nums[i]<nums[i-1]){
                down = Math.max(down,up+1);
            }
        }
        return Math.max(down,up);
    }
}
