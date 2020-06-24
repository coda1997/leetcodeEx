package course;

public class PivotIndex{
    public int pivotIndex(int[] nums) {
        int lsum = 0;
        int rsum = 0;
        for (int i : nums) {
            rsum+=i;
        }
        for (int i = 0; i < nums.length; i++) {
            var item = nums[i];
            rsum-=item;
            if(lsum==rsum){
                return i;
            }else{
                lsum+=item;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a=0,c=0;
        do{
            c--;
            a-=1;
        }while(a>0);
        System.out.println(c);
    }
}