package leetCode;

public class Ex162 {
    public int findPeakElement(int[] nums) {
        if (nums==null||nums.length==1){
            return 0;
        }
        if (nums.length==2){
            return nums[0]>nums[1]?0:1;
        }
        int i = 0, j = nums.length;
        int mid ;
        while (i < j) {
            mid = (j -i)/2+i;
            if (mid==0){
                return 0;
            }
            if (nums[mid - 1] > nums[mid]) {

                j = mid ;
            }else {
                i = mid+1;
            }
        }


        return i-1;
    }
}
