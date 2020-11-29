package leetCode;

public class Ex493 {
    public int reversePairs(int[] nums) {
        if(nums == null){
            return 0;
        }
        return helper(nums, 0, nums.length);

    }
    private int helper(int[] nums, int left, int right){
        if(right-left<2){
            return 0;
        }
        if(right-left==2){
            int res = 0;
            if((long)nums[left]>2l*(long)nums[left+1]){
                res++;
            }
            if(nums[left]>nums[left+1]){
                var t = nums[left];
                nums[left] = nums[left+1];
                nums[left+1] = t;
            }
            return res;
        }

        int mid = (right-left)/2+left;
        int n1 = helper(nums, left, mid+1);
        int n2 = helper(nums, mid+1, right);
        int res = n1+n2;
        int j = mid+1;
        for (int i = left; i < mid+1; i++) {
            while(j<right&&(long)nums[i]>2l*(long)nums[j]){
                j++;
            }
            res += j - mid - 1;
        }

        var temp = new int[right-left];
        int ii = left;
        int jj = mid+1;
        int p = 0;
        while(ii<mid+1&&jj<right){
            if(nums[ii]<nums[jj]){
                temp[p++] = nums[ii++];
            }else{
                temp[p++] = nums[jj++];
            }
        }
        while(ii<mid+1){
            temp[p++] = nums[ii++];
        }
        while(jj<right){
            temp[p++] = nums[jj++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[left+i] = temp[i];
        }
        return res;
    }
}
