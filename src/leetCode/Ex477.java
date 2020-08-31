package leetCode;
/**
 * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
 * 计算一个数组中，任意两个数之间汉明距离的总和。
 */
public class Ex477 {
    //直接用异或会导致时间超时，得通过每个位上面得1与0得个数直接相乘进行计算；
    //才可以保证一个合理得时间复杂度
    public int totalHammingDistance(int[] nums) {
        int res= 0;
        int len = nums.length;
        for (int i = 0; i < 32; i++) {
            int t = 0;
            for (int j = 0; j < nums.length; j++) {
                t += nums[j]&1;
                nums[j] >>= 1;
            }
            res += t*(len-t);
        }
        return res;
    }
    public static void main(String[] args) {
        var o = new Ex477();
        System.out.println( o.totalHammingDistance(new int[]{4,14,2}));
    }
}