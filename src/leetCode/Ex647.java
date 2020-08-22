package leetCode;

public class Ex647 {
    public int countSubstrings(String s) {
        char[] tt = new char[s.length()*2+3];
        int k = 2;
        int len = tt.length-1;
        tt[0] = '!';tt[1] = '#';
        for (char c :
                s.toCharArray()) {
            tt[k++] = c;
            tt[k++]  = '#';
        }
        tt[k] = '?';

        int rightMax = 0, iMax = 0;
        int[] f = new int[tt.length];
        int res = 0;
        for (int i = 2; i < len; i++) {
            if (i<=rightMax){
                f[i] = Math.min(f[2*iMax-i], rightMax-i+1);
            }else{
                f[i] = 1;
            }
            while (tt[i+f[i]]==tt[i-f[i]]){
                f[i]++;
            }
            if(i+f[i]-1>iMax){
                iMax = i+f[i]-1;
                rightMax = i;
            }
            res += f[i]/2;
        }
        return res;
    }
}
