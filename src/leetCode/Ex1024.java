package leetCode;

import java.util.Arrays;

public class Ex1024 {
    // dp 方法
    public int videoStitching(int[][] clips, int T) {
        int[] dp = new int[T+1];
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;
        for (int i = 1; i <= T; i++) {
            for (int[] clip : clips) {
                if(clip[0]<i&&clip[1]>=i){
                    dp[i] = Math.min(dp[clip[0]]+1, dp[i]);
                }
            }
        }
        return dp[T]==Integer.MAX_VALUE-1?-1:dp[T];
    }
    //贪心方法
    public int videoStitching2(int[][] clips, int T) {
        int[] maxs = new int[T];
        for (int[] clip : clips) {
            if(clip[0]<T){
                maxs[clip[0]] = Math.max(maxs[clip[0]],clip[1]);
            }
        }
        int cur = 0;
        int res = 0;
        int rmax = 0;
        for (int i = 0; i < T; i++) {
            cur = Math.max(maxs[i], cur);
            if(cur==i){
                return -1;
            }
            if(i==rmax){
                res++;
                rmax = cur;
            }
        }
        return res;
    }
}
