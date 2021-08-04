package leetCode;

import java.util.Arrays;

public class Ex611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i]==0){
                continue;
            }
            int l = i+1;
            int r = i+2;
            while (l<nums.length-1){
                int temp = nums[i]+nums[l];
                while (r<nums.length&&temp>nums[r]){
                    r++;
                }
                ret+=r-l-1;
                l++;
            }
        }
        return ret;
    }
}
