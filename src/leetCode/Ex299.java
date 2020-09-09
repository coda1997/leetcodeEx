package leetCode;

public class Ex299 {
    public String getHint(String secret, String guess) {
        int[] t = new int[10];
        int[] p = new int[10];
        var ss = secret.toCharArray();
        var gg = guess.toCharArray();
        int a = 0;
        int b = 0;
        for (int i = 0; i < gg.length; i++) {
            if(ss[i]==gg[i]){
                a++;
            }else{
                t[ss[i]-'0']++;
                p[gg[i]-'0']++;
            }
        }
        for (int i = 0; i < 10; i++) {
            b += Math.min(t[i], p[i]);
        }
        return String.format("%dA%dB", a,b);
    }
}
