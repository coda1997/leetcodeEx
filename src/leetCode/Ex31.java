package leetCode;

public class Ex31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len<2){
            return;
        }
        int l = -1;
        int r = -1;
        
        int pre = nums[len-1];
        for (int i = len-2; i >= 0; i--) {
            if(nums[i]<pre){
                l = i;
                break;
            }else{
                pre = nums[i];
            }
        }
        if(l==-1){
            for (int i = 0; i < len&& i<len-i-1; i++) {
                swap(nums, i, len-i-1);
            }
            return;
        }
        for (int i = len-1; i > l; i--) {
            if(nums[i]>nums[l]){
                r = i;
                break;
            }
        }
        //swap l and r;
        swap(nums, l, r);
        for (int i = l+1; i < len&& i<len-i+l; i++) {
            swap(nums, i, len-i+l);
        }

    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
