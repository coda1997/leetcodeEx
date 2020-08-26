package leetCode;
/**
 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
 */
public class Ex334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int f = Integer.MAX_VALUE, s = Integer.MAX_VALUE;
        for (int i : nums) {
            if(i>s){
                return true;
            }else if(i>f){
                s = i;
            }else{
                f = i;
            }
        }
        return false;
    }
}