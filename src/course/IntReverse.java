package course;

public class IntReverse {
    public int reverse(int x) {
        int res = 0;
        var s = Integer.toString(x).toCharArray();
        int ii = 0;// if x < 0, ii = 1;
        if(s[0]=='-'){
            ii=1;
        }
        
        boolean endZero = true;
        //from the last one to the first one without the minus symbol.
        //check the res whether it out of range.
        for(int i=s.length-1;i>=ii;i--){
            if(endZero){
                if(s[i]!='0'){
                    endZero = false;
                    res = s[i]-'0';
                }
            }else{
                if(res>Integer.MAX_VALUE/10){
                    return 0;
                }
                res *=10;
                int temp = s[i] - '0';
                if(res>Integer.MAX_VALUE-temp){
                    if(res==Integer.MAX_VALUE-temp+1){
                        res = -res;
                        return res - temp;
                    }
                    return 0;
                }
                res += temp;
            }
        }

        if(x<0){
            return -res;
        }else{
            return res;
        }
    }

    public static void main(String[] args) {
        var res = new IntReverse();
        System.out.println( res.reverse(1534236469));
    }
}