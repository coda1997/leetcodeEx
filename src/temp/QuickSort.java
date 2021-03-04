package temp;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] nums) {
        quickSort(nums, 0, nums.length);
        return nums;
    }

    private void quickSort(int[] nums, int i, int j){
        if (j<=i){
            return;
        }
        int p = partition(nums, i, j);
        quickSort(nums, i, p);
        quickSort(nums, p+1, j);
    }

    private int partition(int[] nums, int left, int right){
        int temp = nums[left];
        int i = left+1;
        int j = right-1;
        while (true){
            while (i < right && nums[i] < temp) {
                i++;
            }
            while (j > 0 && nums[j] > temp) {
                j--;
            }
            if(i>=j){
                break;
            }else{
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        var o = new QuickSort();
        System.out.println(Arrays.toString(o.quickSort(new int[]{5, 4, 3, 2, 1})));
    }
}
