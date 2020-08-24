package course;

public class RepeatSubStringPattern {
    public boolean repeatedSubstringPattern(String s) {
        var cc = s.toCharArray();
        for (int i = 1; i < cc.length; i++) {
            if(cc.length%i!=0){
                continue;
            }
            int t = i;
            while(t<cc.length){
                if(cc[t]!=cc[t%i]){
                    break;
                }
                t++;
            }
            if(t==cc.length){
                return true;
            }
        }
        return false;
    }
}