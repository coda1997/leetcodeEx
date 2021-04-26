package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int r = nums.length - 1;
            int t = -nums[i];
            for (int k = i + 1; k < r; k++) {
                if (k > 0 && nums[k] == nums[k - 1]) {
                    continue;
                }
                while (r>i&&nums[k] + nums[r] > t) {
                    r--;
                }
                if (r == k) {
                    break;
                }
                if (nums[r] + nums[k] == -nums[i]) {
                    var temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[k]);
                    temp.add(nums[r]);
                    res.add(temp);
                }
            }
        }
        return res;

    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int r = nums.length-1;
            int k = i+1;

            while (k<r){
                int t = nums[i]+nums[k]+nums[r];
                if (Math.abs(t - target) < min) {
                    min = Math.abs(t - target);
                    res = t;
                }
                if (t>target){
                    r--;
                } else if (t < target) {
                    k++;
                }else{
                    return target;
                }
            }

        }
        return res;
    }
}
