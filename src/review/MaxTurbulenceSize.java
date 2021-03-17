package review;

public class MaxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length <1) {
            return arr.length;
        }
        int res = 1;
        int left = 0, right = 0;
        while (right<arr.length-1){
            if (left == right) {
                right++;
                if (arr[right-1]==arr[right]){
                    left = right;
                }
            }else{
                if (arr[right-1]<arr[right]&&arr[right]>arr[right+1]){
                    right++;
                }else if (arr[right-1]>arr[right]&&arr[right]<arr[right+1]){
                    right++;
                }else{
                    left = right;
                }
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new MaxTurbulenceSize();
        System.out.println(o.maxTurbulenceSize(new int[]{4, 8, 12, 16}));
        System.out.println(o.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        System.out.println(o.maxTurbulenceSize(new int[]{9,9}));
    }
}
