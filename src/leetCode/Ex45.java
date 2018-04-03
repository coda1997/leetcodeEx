package leetCode;

public class Ex45 {
    public int jump(int[] nums) {
//        boolean[] reach = new boolean[nums.length];
        int res = 0;
        int temp = nums.length-1;
        while (temp>0){
            int t = temp;
            for (int i = temp-1;i>=0;i--){
                if (nums[i]+i>=temp){
                    t = i;
                }
            }
            temp=t;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Ex45().jump(new int[]{2,3,1,1,4}));
    }
}
