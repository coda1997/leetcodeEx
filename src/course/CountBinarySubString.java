package course;

public class CountBinarySubString {
    public int countBinarySubstrings(String s) {
        var preCount = 0;
        var curCount = 0;
        var res = 0;
        char t = ' ';
        for (char c : s.toCharArray()) {
            if (t == c) {
                curCount++;
            } else {
                t = c;
                res += Math.min(curCount, preCount);
                preCount = curCount;
                curCount = 1;
            }
        }
        res += Math.min(curCount, preCount);
        return res;
    }

    public static void main(String[] args) {
        var o = new CountBinarySubString();
        System.out.println(o.countBinarySubstrings("0011"));
    }
}
