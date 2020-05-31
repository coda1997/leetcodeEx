package course;

public class VersionControl {
    private boolean isBadVersion(int n){
        if(n>=2147483647){
            return true;
        }
        return false;
    }
    public int firstBadVersion(int n) {
        //binary search
        long l = 0;
        long r = n;
        while(l<r){
            var mid = (l+r)/2;
            if(isBadVersion((int)(mid+1))){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        return (int)(l+1);
    }
    public static void main(String[] args) {
        
        System.out.println( new VersionControl().firstBadVersion(2147483647));
    }
}