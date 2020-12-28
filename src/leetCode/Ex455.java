package leetCode;

import java.util.Arrays;

public class Ex455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int tp = 0;
        for (int j : g) {
            while (tp < s.length && j > s[tp]) {
                tp++;
            }
            if (tp == s.length) {
                return res;
            }
            tp++;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Ex455();
        var r1 = o.findContentChildren(new int[]{1, 2, 3,}, new int[]{1, 1});
        assert r1 == 1;
        var r2 = o.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
        assert r2 == 2;
    }

}
