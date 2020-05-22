package course;

public class CommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        var com = strs[0];
        if(strs.length==1){
            return com;
        }
        for(int i =1;i<strs.length;i++){
            com = helper(com, strs[i]);
        }
        return com;
    }

    private String helper(String s1, String s2){
        var c1 = s1.toCharArray();
        var c2 = s2.toCharArray();
        int len = c1.length<c2.length?c1.length:c2.length;
        int c = 0;
        for(int i = 0;i<len;i++){
            if(c1[i]!=c2[i]){
                break;
            }else{
                c++;
            }
        }
        return s1.substring(0, c);
    }
}