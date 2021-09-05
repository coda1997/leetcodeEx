package swordtooffer;

public class HeapSort {
    private int len;

    private void buildMaxHeap(int[] nums){
        len = nums.length;
        for (int i = (int) Math.floor(len / 2); i>=0; i--) {
            resetToHeap(nums, i);
        }
    }

    private void heapSort(int[] nums){
        buildMaxHeap(nums);
        for (int i = nums.length-1; i >=0; i--) {
            swap(nums, i, 0);
            len--;
            resetToHeap(nums, 0);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void resetToHeap(int[] nums, int i){
        int left = i*2+1;
        int right = i*2+2;
        int largest = i;
        if (left<len&&nums[left]>nums[largest]){
            largest = left;
        }
        if (right<len&&nums[right]>nums[largest]){
            largest = right;
        }
        if (largest!=i){
            swap(nums, largest, i);
            resetToHeap(nums, largest);
        }
    }
}
