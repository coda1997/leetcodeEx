package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ex164 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = num<min?num:min;
            max = num>max?num:max;
        }
        int size = (max-min)/nums.length+1;
        int bucketNums = (max-min)/size+1;
        int[] maxBucket = new int[bucketNums];
        int[] minBucket = new int[bucketNums];
        Arrays.fill(maxBucket,Integer.MIN_VALUE);
        Arrays.fill(minBucket,Integer.MAX_VALUE);
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            int index = (num-min)/size;
            minBucket[index] = Math.min(minBucket[index],num);
            maxBucket[index] = Math.max(maxBucket[index],num);
            set.add(index);
        }
        int res = 0;
        int pre = 0;
        for (int i = 1; i <nums.length; i++) {
            if (!set.contains(i)){continue;}
            res = Math.max(res,Math.abs(minBucket[i]-maxBucket[pre]));
            pre = i;
        }
        return res;
    }
}
