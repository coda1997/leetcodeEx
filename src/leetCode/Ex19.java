package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex19 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 4) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len-3; i++) {
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if(nums[i]+nums[len-1]+nums[len-2]+nums[len-3]<target){
                continue;
            }
            for (int j = i+1; j < len-2; j++) {
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                int temp = nums[i]+nums[j];
                if(temp+nums[j+1]+nums[j+2]>target){
                    break;
                }
                if(temp+nums[len-1]+nums[len-2]<target){
                    continue;
                }
                int m = j+1, n = len-1;
                while(m<n){
                    if(temp+nums[m]+nums[n]>target){
                        n--;
                    }else if(temp+nums[m]+nums[n]<target){
                        m++;
                    }else{
                        res.add(List.of(nums[i], nums[j],nums[m],nums[n]));
                        while(m<n&&nums[n-1]==nums[n]){
                            n--;
                        }
                        n--;
                        while(m<n&&nums[m+1]==nums[m]){
                            m++;
                        }
                        m++;
                    }
                }
            }
        }
        return res;
    }

}
