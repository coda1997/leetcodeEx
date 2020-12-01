package leetCode;

import java.util.Arrays;

public class Ex34 {
    public int[] searchRange(int[] nums, int target) {
        int l = helper(nums, target-0.5f);
        int r = helper(nums, target+0.5f);
        if(l==r){
            return new int[]{-1,-1};
        }else{
            return new int[]{l, r-1};
        }
    }

    private int helper(int[] nums, float target){
        int l = 0;
        int r = nums.length;
        while(l<r){
            int mid = (r-l)/2+l;
            if(nums[mid]<target){
                l= mid+1;
            }else{
                r = mid;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        var o = new Ex34();
        // var res = o.searchRange(new int[]{5,7,7,8,8,10}, 8);
        var res = o.searchRange(new int[]{}, 6);        
        // var res = o.searchRange(new int[]{5,7,7,8,8,10}, 6);        

        System.out.println(Arrays.toString(res));
    }
}
