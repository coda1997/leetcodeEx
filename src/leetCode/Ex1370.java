package leetCode;

public class Ex1370{
    public String sortString(String s) {
        int len = s.length();
        int[] t = new int[26];
        for (char i: s.toCharArray()) {
            t[i-'a']++;
        }
        char[] res = new char[len];
        int p = 0;
        while(p<len){
            for (int i = 0; i < 26; i++) {
                if(t[i]>0){
                    t[i]--;
                    res[p++] = (char)(i+'a');
                }
            }
            for (int i = 25; i >= 0; i--) {
                if(t[i]>0){
                    t[i]--;
                    res[p++] = (char)(i+'a');
                }
            }
        }
        return String.valueOf(res);
    }
}