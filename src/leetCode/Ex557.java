package leetCode;

public class Ex557 {
    public String reverseWords(String s) {
        var cc = s.toCharArray();
        int i = -1, j = -1;
        for (int k = 0; k < cc.length; k++) {
            if(cc[k]==' '){
                i = j;
                j = k;
                helper(cc, i+1, j-1);
            }
        }
        //the last one
        helper(cc, j+1, cc.length-1);
        return new String(cc);
    }


    private void helper(char[] cc, int i, int j){
        char t;
        while(i<j){
            t = cc[i];
            cc[i] = cc[j];
            cc[j]= t;
            i++;
            j--;
        }
    }
}