package swordtooffer;

public class FindRepeatNumber{
    public int findRepeatNumber(int[] nums) {
        int p = 0;
        while(p<nums.length){
            if(nums[p]<0){
                p++;
                continue;
            }
            //nums[p]>=0
            var item = nums[p];
            if(nums[item]<=-1){
                nums[item]--;
                p++;
            }else{
                if(nums[item]==p){
                    nums[item] = -1;
                    p++;
                }else{
                    nums[p] = nums[item];
                    nums[item] = -1;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<-1){
                return i;
            }
        }
        return 0;
    }
}