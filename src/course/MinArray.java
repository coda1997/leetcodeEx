package course;

public class MinArray {
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length-1;
        while(low<high){
            int mid = (high-low)/2+low;
            if(numbers[high]>numbers[mid]){
                high = mid;
            }else if(numbers[high]<numbers[mid]){
                low = mid+1;
            }else{
                high--;
            }
        }
        return numbers[low];
    }

   
    public static void main(String[] args) {
        var o = new MinArray();
        System.out.println(o.minArray(new int[]{3,4,5,1,2}));
        System.out.println(o.minArray(new int[]{2,2,2,0,1}));
        System.out.println(o.minArray(new int[]{1,2,3}));
        System.out.println(o.minArray(new int[]{3,1}));
    }
}