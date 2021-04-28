package leetCode;

public class Ex633 {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int)Math.sqrt(c);
        while (left < right) {
            int t = left*left+right*right;
            if (t == c) {
                return true;
            }
            if (t<c){
                left++;
            }else{
                right--;
            }
        }
        return false;
    }
}
