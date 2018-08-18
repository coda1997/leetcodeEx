package leetCode;

public class Ex125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0;
        int j = s.length() - 1;
        int len = s.length();
        for (char c :
                s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {

                while (i < j) {
                    while (i < len && !Character.isLetterOrDigit(s.charAt(i))) {
                        i++;
                    }
                    while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                        j--;
                    }
                    if (i == len || j < 0 || s.charAt(i) != s.charAt(j)) {
                        return false;
                    }
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
}
