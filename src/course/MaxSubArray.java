package course;

public class MaxSubArray {
    class Status {
        int lsum;
        int rsum;
        int isum;
        int msum;

        public Status(int lsum, int rsum, int isum, int msum) {
            this.lsum = lsum;
            this.rsum = rsum;
            this.isum = isum;
            this.msum = msum;
        }
    }

    // 分治法
    private Status helper(int i, int j, int[] nums) {
        if (i == j) {
            var t = nums[i];
            
            return new Status(t, t, t, t);
        }
        int m = (j +i)>>1;
        var l = helper(i, m, nums);
        var r = helper(m + 1, j, nums);
        int isum = l.isum + r.isum;
        int lsum = Math.max(l.lsum, l.isum + r.lsum);
        int rsum = Math.max(r.rsum, r.isum + l.rsum);
        int msum = Math.max(l.msum, Math.max(r.msum, l.rsum + r.lsum));
        return new Status(lsum, rsum, isum, msum);
    }

    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        var status = helper(0, nums.length-1, nums);
        return status.msum;
    }
    public static void main(String[] args) {
        var s = new MaxSubArray();
        System.out.println( s.maxSubArray(new int[]{1,2,-1,-2,2,1,-2,1}));

    }
}