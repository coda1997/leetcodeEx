package leetCode;


import java.util.StringTokenizer;

public class Ex165 {
    public int compareVersion(String version1, String version2) {
        StringTokenizer tokenizer1 = new StringTokenizer(version1,".");
        StringTokenizer tokenizer2 = new StringTokenizer(version2,".");

        while (tokenizer1.hasMoreTokens()&&tokenizer2.hasMoreTokens()){
            int t1 = getInt(tokenizer1.nextToken());
            int t2 = getInt(tokenizer2.nextToken());
            if (t1<t2){
                return -1;
            }else if(t1>t2){
                return 1;
            }
        }
        while (tokenizer1.hasMoreTokens()){
            if (getInt(tokenizer1.nextToken()) != 0) {
                return 1;
            }
        }
        while (tokenizer2.hasMoreTokens()){
            if (getInt(tokenizer2.nextToken()) != 0) {
                return -1;
            }
        }
        return 0;
    }
    private int getInt(String s){
        return Integer.parseInt(s);
    }
}
