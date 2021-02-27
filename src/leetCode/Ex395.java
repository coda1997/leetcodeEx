package leetCode;

public class Ex395 {
    //分治的方法
    public int longestSubstring2(String s, int k) {
        return dfs(s.toCharArray(), 0, s.length(), k);
    }

    private int dfs(char[] s, int i, int j, int k){
        if (j-i<k){
            return 0;
        }
        int[] ts = new int[26];
        for (int l = i; l < j; l++) {
            ts[s[l]-'a']++;
        }
        int pre = i;
        int res = 0;
        for (int l = i; l < j; l++) {
            if (ts[s[l]-'a']>0&&ts[s[l]-'a']<k){
                if (l-pre>=k){
                    res = Math.max(res, dfs(s, pre, l, k));
                }
                pre = l+1;
            }
        }
        if (pre==i){
            return j-i;
        }
        if (j-pre>=k){
            res = Math.max(res, dfs(s, pre, j, k));
        }
        return res;
    }
    //滑窗的方法
    public int longestSubstring(String s, int k) {
        int len = s.length();
        if (k==1){
            return len;
        }
        char[] ss = s.toCharArray();
        int less = 0;
        int[] ts = new int[26];
        for (int l = 0; l < len; l++) {
            ts[ss[l]-'a']++;
            if (ts[ss[l]-'a']<k){
                less++;
            }
            for (int i = 0; i < l; i++) {

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        var o = new Ex395();
        System.out.println(o.longestSubstring("aaabb", 3));
        System.out.println(o.longestSubstring("ababbc", 2));
    }
}
