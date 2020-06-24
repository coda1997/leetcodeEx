package course;

public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            var temp = 0;
            int count = 0;
            for (int j = i; j >=0; j--) {
                temp+=nums[j];
                count++;
                if(temp>=s){
                    min = Math.min(min, count);
                    break;
                }
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen().minSubArrayLen(1,new int[]{1}));
    }
}