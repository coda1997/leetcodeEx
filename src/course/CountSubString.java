package course;
/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串.
 */
public class CountSubString {
    public int countSubstrings(String s) {
        int res = 0;
        var cc = s.toCharArray();
        var ss = new char[cc.length*2+1];
        ss[0] = '#';
        int t = 1;
        for (int i = 0; i < cc.length; i++) {
            ss[t]=cc[i]; 
            t++;
            ss[t]='#';
            t++;
        }
        for (int i = 0; i < ss.length; i++) {
            res += helper(ss, i);
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
        return c/2;
    }
}