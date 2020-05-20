package course;

public class IsStringRe {
    public boolean isPalindrome(String s) {
        if(s.length()<2){
            return false;
        }
        s = s.toLowerCase();
        var ss = s.toCharArray();
        int l = 0;
        int r = ss.length-1;
        while(l<r){
            while(!Character.isLetterOrDigit(ss[l])){
                l++;
            }
            while(!Character.isLetterOrDigit(ss[r])){
                r--;
            }
            if(l<r){
                if(ss[l]!=ss[r]){
                    return false;
                }
                l++; r--;
            }
        }
        return true;   
    }
    public static void main(String[] args) {
        System.out.println( new IsStringRe().isPalindrome("A man, a plan, a canal: Panama"));
    }
}