package course;

public class StringMatch {
    public boolean isMatch(String s, String p) {
        // using a dp method;
        var ss = s.toCharArray();
        var pp = p.toCharArray();
        boolean[][] dp = new boolean[ss.length+1][pp.length+1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i-1] && pp[i-1]=='*';
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                boolean s1 = dp[i-1][j-1]&& (ss[i-1]==pp[j-1]||pp[j-1]=='*'||pp[j-1]=='?');
                boolean s2 = dp[i][j-1]&&(pp[j-1]=='*');
                boolean s3 = dp[i-1][j]&&(pp[j-1]=='*');
                dp[i][j] = s1||s2||s3;
            }
        }
        return dp[ss.length][pp.length];
    }
 

    

    public static void main(String[] args) {
        var o = new StringMatch();
        System.out.println(o.isMatch("aa", "a"));
        System.out.println(o.isMatch("aa", "aa"));
        System.out.println(o.isMatch("aa", "a?"));
        System.out.println(o.isMatch("aa", "a*"));
        System.out.println(o.isMatch("aa", "*"));
        System.out.println(o.isMatch("aa", "**"));
        System.out.println(o.isMatch("aa", "?*"));
        System.out.println(o.isMatch("aa", "?"));
        System.out.println(o.isMatch("aa", "??"));
    }
}