package leetCode;

public class Ex91 {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int[] t = new int[s.length() + 1];
        t[0] = 1;
        t[1] = 1;

        char[] ss = s.toCharArray();
        for (int i = 2; i < s.length() + 1; i++) {
            if (ss[i - 2] == '1' || (ss[i - 2] == '2' && ss[i - 1] >= '0' && ss[i - 1] <= '6')) {
                if (ss[i - 1] == '0') {
                    t[i] = t[i - 2];
                } else {

                    t[i] = t[i - 2] + t[i - 1];
                }
            } else {
                if (ss[i - 1] == '0') {
                    return 0;
                }
                t[i] = t[i - 1];

            }
        }
        return t[s.length()];
    }
}
