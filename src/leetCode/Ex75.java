package leetCode;

public class Ex75 {
    public void sortColors(int[] nums) {
        int t = 0, p = nums.length-1;
        int i = 0;
        while(i <= p) {
            if(nums[i]==0&&i!=t){
                    nums[i] = nums[t];
                    nums[t++] = 0;
            }else if(nums[i]==2){
                nums[i] = nums[p];
                nums[p--] = 2;
            }else{
                i++;
            }
        }
    }
}
