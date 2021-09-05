package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        var res = new ArrayList<List<Integer>>();
        if (nums==null||nums.length<4){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if (nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target){
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                if (nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;
                }
                if (nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while (left<right){
                    int temp = nums[i]+nums[j]+nums[left]+nums[right];
                    if (temp>target){
                        right--;
                    }else if (temp<target){
                        left++;
                    }else{
                        res.add(List.of(nums[i],nums[j],nums[left],nums[right]));
                        while (left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        left++;
                        while (left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
