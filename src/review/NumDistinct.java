package review;

public class NumDistinct {
    int res = 0;

    public int numDistinct(String s, String t) {
        var ss = s.toCharArray();
        var tt = t.toCharArray();
        helper(ss, tt, 0, 0);
        return res;
    }

    private void helper(char[] s, char[] t, int i, int j) {
        if (j == t.length) {
            res++;
            return;
        }
        if (i == s.length) {
            return;
        }
        for (int k = i; k < s.length; k++) {
            if (s[k] == t[j]) {
                helper(s, t, k + 1, j + 1);
            }
        }
    }

    public int numDistinct2(String s, String t) {
        var ss = s.toCharArray();
        var tt = t.toCharArray();
        if (ss.length == 0 || tt.length == 0) {
            return 0;
        }
        int[][] dp = new int[ss.length][tt.length];
        for (int j = 0; j < tt.length; j++) {
            for (int i = 0; i < ss.length; i++) {
                boolean f = ss[i] == tt[j];
                if (i > 0) {
                    if (j > 0) {
                        dp[i][j] = dp[i - 1][j] + (f ? dp[i - 1][j - 1] : 0);
                    } else {
                        dp[i][j] = dp[i - 1][j] + (f ? 1 : 0);
                    }
                } else {
                    if (j > 0) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = f ? 1 : 0;
                    }
                }
            }
        }

        return dp[ss.length - 1][tt.length - 1];
    }

    public static void main(String[] args) {
        var o = new NumDistinct();
        System.out.println(o.numDistinct2("rabbbit", "rabbit"));
    }
}
