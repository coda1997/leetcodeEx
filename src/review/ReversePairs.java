package review;

public class ReversePairs {
    private int[] nums;
    private int[] hs;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        this.hs = new int[nums.length];
        return mergeSort(0, nums.length - 1);
    }

    private int mergeSort(int i, int j) {
        if (i >= j) {
            return 0;
        }
        int mid = (j - i) / 2 + i;
        int t1 = mergeSort(i, mid);
        int t2 = mergeSort(mid + 1, j);
        int temp = 0;
        int li = i;
        int ri = mid + 1;
        int index = i;
        while (index <= j) {
            if (li == mid + 1) {
                hs[index++] = nums[ri++];
            } else if (ri > j) {
                hs[index++] = nums[li++];
            } else if (nums[li] > nums[ri]) {
                hs[index++] = nums[li++];
                temp += j - ri + 1;
            } else {
                hs[index++] = nums[ri++];
            }
        }
        if (j + 1 - i >= 0) {
            System.arraycopy(hs, i, nums, i, j + 1 - i);
        }
        return t1 + t2 + temp;
    }
}
