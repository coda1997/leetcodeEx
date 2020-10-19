package leetCode;

public class Ex844 {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int cs = 0, ct = 0;
        while (i >= 0 || j >= 0) {
            while(i>=0){
                if(S.charAt(i)=='#'){
                    cs++;
                    i--;
                }else if(cs>0){
                    i--;
                    cs--;
                }else{
                    break;
                }
            }
            while(j>=0){
                if(T.charAt(j)=='#'){
                    ct++;
                    j--;
                }else if(ct>0){
                    ct--;
                    j--;
                }else{
                    break;
                }
            }
            if(i<0||j<0){
                break;
            }
            if (S.charAt(i) != T.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return i<0&&j<0;
    }
}
