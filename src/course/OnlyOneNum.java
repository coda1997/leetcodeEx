package course;

public class OnlyOneNum {
    public int firstUniqChar(String s) {
        int[] c = new int[26];
        for(int i = 0;i<26;i++){
            c[i] = -1;
        }
        var cc = s.toCharArray();
        for(int i =0;i<cc.length;i++){
            if(c[cc[i]-'a']>=0){
                c[cc[i]-'a'] = -2;
            }else if(c[cc[i]-'a']==-1){
                c[cc[i]-'a'] = i;
            }
        }
        int res = cc.length;
        for(int i = 0;i<26;i++){
            if(c[i]>=0){
                res = res < c[i] ? res:c[i];
            }
        }
        return res==c.length?-1:res;
    }
    public static void main(String[] args) {
        new OnlyOneNum().firstUniqChar("itwqbtcdprfsuprkrjkausiterybzncbmdvkgljxuekizvaivszowqtmrttiihervpncztuoljftlxybpgwnjb");
    }
}