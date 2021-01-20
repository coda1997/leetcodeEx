package leetCode;

public class Ex628 {
    public int maximumProduct(int[] nums) {
        int max1, max2, max3, min1, min2;
        max1 = max2 = max3 = Integer.MIN_VALUE;
        min1 = min2 = Integer.MAX_VALUE;
        for (var item :
                nums) {
            if(item>max1){
                max3 = max2;
                max2 = max1;
                max1 = item;
            }else if(item>max2){
                max3 = max2;
                max2 = item;
            }else if(item>max3){
                max3 = item;
            }
            if(item<min1){
                min2 = min1;
                min1 = item;
            }else if(item<min2){
                min2 = item;
            }
        }

        return Math.max(max1*max2*max3, min1*min2*max1);
    }

    public static void main(String[] args) {
        var o = new Ex628();
        System.out.println(o.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(o.maximumProduct(new int[]{1, 2, 3, 4}));
    }

}
