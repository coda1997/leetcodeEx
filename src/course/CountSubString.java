package course;

public class CountSubString {
    public int countSubstrings(String s) {
        int res = 0;
        var cc = s.toCharArray();
        for (int i = 0; i < cc.length; i++) {
            res += helper(cc, i);
        }
        return res;
    }


    private int helper(char[] ss, int i){
        int c = 1;
        for (int j = 1; j+i < ss.length&&i-j>=0; j++) {
            if(ss[i-j]!=ss[i+j]){
                break;
            }
            c++;
        }
        return c;
    }
}