package leetCode;

public class Ex97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return isLeave(s1, s2, s3, 0, 0, 0);
    }

    private boolean isLeave(String s1, String s2, String s3, int i, int j, int k) {
        if (s3.length() == k) {
            return true;
        }

        return i<s1.length()&&s3.charAt(k) == s1.charAt(i)&&isLeave(s1, s2, s3, i + 1, j, k + 1)||
                j<s2.length()&&s3.charAt(k) == s2.charAt(j)&&isLeave(s1, s2, s3, i, j + 1, k + 1);

    }
}
