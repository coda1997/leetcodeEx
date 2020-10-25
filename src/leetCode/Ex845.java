package leetCode;

public class Ex845 {
    public int longestMountain(int[] A) {
        int res = 0;
        int count = 0;
        boolean left = false;
        int cc = 0;
        for(int i = 1;i<A.length;i++){
            if(A[i]>A[i-1]){
                if(left){
                    count++;                
                }else{
                    left=true;
                    res = Math.max(res, count);
                    count=2;
                }
            }else if(A[i]<A[i-1]){
                if(left){
                    cc++;
                }
                left= false;
                count++;
            }else{
                res = Math.max(res,count);
                count=0;
            }
        }
        if(cc>0){
            res = Math.max(res, count);
        }
        return res>=3?res:0;
    }
}
