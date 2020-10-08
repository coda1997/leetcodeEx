package leetCode;

public class Ex541 {
    public String reverseStr(String s, int k) {
        char[] cc = s.toCharArray();
        for(int l = 0;l<cc.length; l+=2*k) {
            int ll = l, rr = Math.min(l+k, cc.length)-1; //may exceed the integer range, but its ok in this case
            while(ll<rr){
                char t = cc[ll];
                cc[ll++] = cc[rr];
                cc[rr--] = t;
            }
        }
        return String.valueOf(cc);
    }
}
