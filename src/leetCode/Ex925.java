package leetCode;

public class Ex925 {
    public boolean isLongPressedName(String name, String typed) {
        char pre = ' ';
        int sl = name.length();
        int tl = typed.length();
        int i=0,j=0;
        while(i<sl&&j<tl){
            var cs = name.charAt(i);
            var ct = typed.charAt(j);
            if(cs==ct){
                i++;j++;
                pre = ct;
            }else if(pre==ct&&j<tl-1){
                while(pre==ct&&j<tl-1){
                    j++;
                    ct = typed.charAt(j);
                }
            }else{
                return false;
            }
        }
        if(i==sl){
            while(j<tl&&pre==typed.charAt(j)){
                j++;
            }
            return j==tl;
        }else{
            return false;
        }
    }
}
