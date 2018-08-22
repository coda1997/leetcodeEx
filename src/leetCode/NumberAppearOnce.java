package leetCode;

public class NumberAppearOnce {

    public void findNumberAppearOnce(int[] nums){
        if (nums==null||nums.length<2){
            System.out.println("the length is not enough");
            return;
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        int i =0;
        int temp = res;
        while ((temp&1)==0&&(i<32)){
            temp=temp>>1;
            i++;
        }
        int i1=0,i2=0;
        //then we get the first bit is 1
        for (int j = 0; j < nums.length; j++) {
            if (isBit1(nums[j],i)){
                i1 ^= nums[j];
            }else {
                i2 ^= nums[j];
            }
        }
        System.out.println("one is "+i1+"; the other is "+i2);
    }
    private boolean isBit1(int num,int indexOfBit){
        num =num >> indexOfBit;
        return (num&1)==1;
    }

    public static void main(String[] args) {
        new NumberAppearOnce().findNumberAppearOnce(new int[]{
                2,4,3,6,3,2,5,5
        });
    }
}
