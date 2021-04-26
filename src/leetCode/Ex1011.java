package leetCode;

public class Ex1011 {
    public int shipWithinDays(int[] weights, int D) {
        int left = 0;
        int right = 0;
        for (int weight : weights) {
            left = Math.max(weight, left);
            right += weight;
        }
        while (left < right) {
            int mid = (right-left)/2+left;
            int cur = 0;
            int d = 1;
            for (int weight : weights) {
                if (cur+weight>mid){
                    d++;
                    cur = 0;
                }
                cur += weight;
            }
            if (d<=D){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
