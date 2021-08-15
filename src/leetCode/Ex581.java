package leetCode;

public class Ex581 {
    public int findUnsortedSubarray(int[] nums) {
        int temp = nums[0];
        int m = nums.length;
        int n = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]<temp){
                m = Math.min(m, i);
                n = Math.max(n, i);
            }
            temp = Math.max(temp, nums[i]);
        }
        temp = nums[nums.length-1];
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i]>temp){
                m = Math.min(m, i);
                n = Math.max(n, i);

            }
            temp = Math.min(temp, nums[i]);
        }
        return Math.max(n-m+1, 0);
    }
}
