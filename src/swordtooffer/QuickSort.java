package swordtooffer;

public class QuickSort {
    public void quickSort(int[] nums){
        helper(nums, 0, nums.length);

    }

    private void helper(int[] nums, int i, int j){
        if (i+1<=j){
            return;
        }
        int mid = compare(nums, i, j);
        helper(nums, i, mid);
        helper(nums, mid+1, j);
    }

    private void swap(int[] nums, int i, int j){

    }

    private int compare(int[] nums, int i, int j){
        int temp = nums[i];
        int left = i;
        int right = j-1;
        while (true){
            while (left<right&&nums[left]<=temp){
                left++;
            }
            while (left<right&&nums[right]>temp){
                right++;
            }
            if (left==right){
                break;
            }else{
                swap(nums, left, right);
            }
        }
        swap(nums, left, i);
        return left;
    }

}
