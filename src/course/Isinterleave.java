package course;

public class Isinterleave{
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }

        return helper(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0,0,0);
    }

    private boolean helper(char[] s1, char[] s2, char[] s3, int i1, int i2, int i3){
        if(i3==s3.length){
            if(i2==s2.length&&i1==s1.length){
                return true;
            }else{
                return false;
            }
        }
        var flag = false;
        if(i1<s1.length&&s1[i1]==s3[i3]){
            flag =  helper(s1, s2, s3, i1+1, i2, i3+1);
        }
        if(i2<s2.length&&s2[i2]==s3[i3]){
            flag = flag || helper(s1, s2, s3, i1, i2+1, i3+1);
        }
        return flag;
    }
    public static void main(String[] args) {
        var o = new Isinterleave();
        System.out.println( o.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

}