package review;

public class Ex5 {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int ti = 0;
        int mLen = 0;
        for (int l = 0;l<len;l++){
            for (int i = 0; i+l < len; i++) {
                if (l==0){
                    dp[i][i] = true;
                }else if (l==1){
                    dp[i][i+l] = s.charAt(i)==s.charAt(i+l);
                }else{
                    dp[i][i+l] = dp[i+1][i+l-1]&&(s.charAt(i)==s.charAt(i+l));
                }
                if (dp[i][i+l]&&mLen<l){
                    mLen = l;
                    ti = i;
                }
            }
        }
        return s.substring(ti,ti+mLen+1);
    }
}
