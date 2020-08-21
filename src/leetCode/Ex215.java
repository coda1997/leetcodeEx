package leetCode;


public class Ex215 {
    class MinHeap{
        private int[] nums;
        private int len;

        MinHeap(int n, int[] temp){
            len = n;
            nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = temp[i];
            }
            for (int i = len/2; i >=0; i--) {
                shiftDown(i);
            }
        }
        void add(int val){
            nums[len] = val;
            len++;
            shiftUp(len-1);
        }
        void removeTop(){
            swap(0, len-1);
            len--;
            shiftDown(0);
        }
        private void shiftDown(int pos){
            int i = pos;
            int j = 2*i+1;
            int temp = nums[i];
            while(j<len){
                if(j<len-1&&nums[j]>nums[j+1]){
                    j++;
                }
                if(temp>nums[j]){
                    nums[i] = nums[j];
                    i = j;
                    j = 2*i+1;
                }else{
                    break;
                }
            }
            nums[i] = temp;
        }
        private int parent(int i){
            if(i%2==0){
                return (i-2)/2;
            }else{
                return (i-1)/2;
            }
        }

        private void shiftUp(int pos){
            int i = pos;
            int temp = nums[i];
            while(i>0&&nums[parent(i)]> temp){
                nums[i] = nums[parent(i)];
                i = parent(i);
            }
            nums[i] = temp;
        }

        int top(){
            return nums[0];
        }

        private void swap(int i, int j){
            int k = nums[i];
            nums[i] = nums[j];
            nums[j] = k;
        }

    }
    
    public int findKthLargest(int[] nums, int k) {
        MinHeap minHeap = new MinHeap(k, nums);

        for (int i = k; i < nums.length; i++) {
            var item = nums[i];
            if(item>minHeap.top()){
                minHeap.removeTop();
                minHeap.add(item);
            }
        }
        return minHeap.top();

    }
}