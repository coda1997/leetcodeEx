package leetCode;

public class Ex87 {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        int len2 = s2.length();
        if(len!=len2){
            return false;
        }
        boolean[][][] dp = new boolean[len][len][len+1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j][1] = true;
                }
            }
        }

        for(int k = 2;k<=len;k++){
            for (int i = 0; i <= len-k; i++) {
                for (int j = 0; j <= len-k; j++) {
                    for (int w = 1; w < k; w++) {
                        if((dp[i][j][w]&&dp[i+w][j+w][k-w])||(dp[i][j+k-w][w]&&dp[i+w][j][k-w])){
                            dp[i][j][k] = true;
                            break;
                        } 
                    }
                }
            }
        }

        return dp[0][0][len];
    }
    public static void main(String[] args) {
        var o = new Ex87();
        System.out.println(o.isScramble("abcdbdacbdac","bdacabcdbdac"));
    }
}
