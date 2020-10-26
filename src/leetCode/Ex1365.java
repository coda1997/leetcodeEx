package leetCode;

import java.util.Arrays;

public class Ex1365 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            for(int j = i+1;j<nums.length;j++){
                if(nums[i]>nums[j]){
                    res[i]++;
                }else if(nums[i]<nums[j]){
                    res[j]++;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        var o = new Ex1365();
        var res = o.smallerNumbersThanCurrent(new int[]{8,1,2,2,3});
        System.out.println(Arrays.toString(res));
    }
}
