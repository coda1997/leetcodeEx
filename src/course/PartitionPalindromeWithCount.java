package course;

public class PartitionPalindromeWithCount {
    public int minCut(String s) {
        var cc = s.toCharArray();
        if(cc.length<2){
            return 0;
        }
        int[] dp = new int[cc.length];
        for (int i = 0; i < dp.length; i++) {
            if(checkPalindrome(cc, 0, i)){
                dp[i]=0;
                continue;
            }
            dp[i]=i;
            for (int j = 0; j <i ; j++) {
                if(checkPalindrome(cc, j+1, i)){
                    dp[i] = Math.min(dp[j]+1, dp[i]);
                }
            }
        }
        return dp[cc.length-1];
    }
    private boolean checkPalindrome(char[] s,int i, int j){
        while(i<j){
            if(s[i]!=s[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        int c = new PartitionPalindromeWithCount().minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp");
        System.out.println(c);
    }
}