package leetCode;

import java.util.Arrays;

public class Ex767 {
    public String reorganizeString(String S) {
        int len = S.length();
        int mid = len / 2;
        if (len % 2 == 1) {
            mid++;
        }
        int[] cs = new int[26];
        int max = 0;
        for (char item : S.toCharArray()) {
            cs[item - 'a']++;
            max = Math.max(max, cs[item-'a']);
        }
        if(max>mid){
            return "";
        }
        int oddi = 1;
        int eveni = 0;
        var res = new char[len];
        for (int i = 0; i < 26; i++) {
            while (cs[i] > 0 && cs[i] <= len / 2 && oddi < len) {
                res[oddi] = (char) (i + 'a');
                oddi += 2;
                cs[i]--;

            }
            while (cs[i] > 0) {
                res[eveni] = (char) (i + 'a');
                eveni += 2;
                cs[i]--;
            }
        }
        return String.valueOf(res);
    }
}
