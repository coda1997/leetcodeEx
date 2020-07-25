package leetCode;

public class Ex410 {
    public int splitArray(int[] nums, int m) {
        //这题可以动归也可以二分
        //动归就不提了，时间复杂度太高
        //下面解法是二分+贪心
        int left = 0, right = 0;
        for (int i : nums) {
            right+= i;
            left = Math.max(left, i);
        }

        while(left<right){
            int mid = (right-left)/2 +left;
            if(check(nums, mid,m)){
                right=mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }

    private boolean check(int[] nums, int sum, int m){
        //这里使用贪心的方法来解决
        int temp = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            var item = nums[i];
            temp+=item;
            if(temp>sum){
                temp=item;
                count++;
            }
        }
        return count<=m;
    }
}