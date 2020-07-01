package swordtooffer;

public class IsMatch {
    public boolean isMatch(String s, String p) {
        return isMatch(s.toCharArray(), p.toCharArray(), 0, 0);
    }
    private boolean isMatch(char[] s, char[] p, int i, int j){
        if(i==s.length){
            if(j==p.length){
                return true;
            }
            if(j+1==p.length||p[j+1]!='*'){
                return false;
            }else{
                return isMatch(s, p,i,j+2);
            }
        }
            if(p.length==j){
                return i==s.length;
            }
        // i, j < len;
        if(p[j]=='.'){
            if(j+1<p.length&&p[j+1]=='*'){
                for (int k = i; k <= s.length; k++) {
                    if(isMatch(s, p, k,j+2)){
                        return true;
                    };
                }
                return false;
            }else{
                return isMatch(s, p,i+1,j+1);
            }
        }else{
            if(j+1<p.length&&p[j+1]=='*'){
                if(isMatch(s, p,i,j+2)){
                    return true;
                }
                for (int k = i+1; k <= s.length; k++) {
                    if(s[k-1]!=p[j]){
                        break;
                    }
                    if(isMatch(s, p, k,j+2)){
                        return true;
                    }
                }
                return false;
            }else{
                if(s[i]==p[j]){
                    return isMatch(s, p, i+1,j+1);
                }else{
                    return false;
                }
            }
        }
    }
    public static void main(String[] args) {
        var o = new IsMatch();
        System.out.println( o.isMatch("aa", "a"));
        System.out.println( o.isMatch("aa", "a*"));
        System.out.println( o.isMatch("aa", ".*"));
        System.out.println( o.isMatch("aa", ".a"));
        System.out.println( o.isMatch("aa", "a.*"));
        System.out.println( o.isMatch("aab", "c*a*b"));
        System.out.println( o.isMatch("aaa", "ab*a"));
        System.out.println( o.isMatch("a", "ab*"));
        System.out.println( o.isMatch("bbab", "b*a*"));
        System.out.println( o.isMatch("ab", "a*"));

    }
}    