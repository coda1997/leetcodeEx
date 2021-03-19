package review;

public class MinHeap {
    private int[] nums;
    private final int capacity;
    private int len;
    public MinHeap(int capacity) {
        this.capacity =capacity;
        nums = new int[capacity];
        len = 0;
    }
    public void add(int value){
        if (len < capacity) {
            nums[len++] = value;
            adjustFromBottomToTop();
        }
    }
    public int size(){
        return len;
    }
    private void adjustFromBottomToTop(){
        //when i is the index of the node, then
        //2*i+1,2*i+2 are its children;
        //(i-1)/2 is its parent.
        //here we have len>0
        int i = len-1;
        int parent;
        while (i>0){
            parent = (i-1)/2;
            if (nums[parent] > nums[i]) {
                swap(i, parent);
                i = parent;
            }else{
                break;
            }
        }
    }

    private void adjustFromTopToBottom(){
        int i = 0;
        int lc, rc;
        while (2*i+2 < len) {
            lc = 2*i+1;
            rc = 2*i+2;//there may be no child of i
            if (nums[i]<nums[lc]&&nums[i]<nums[rc]){
                break;
            }
            int temp = nums[lc]<nums[rc]? lc:rc;
            swap(i, temp);
            i = temp;
        }
        lc = 2*i+1;
        if (lc < len) {
            if (nums[lc] < nums[i]) {
                swap(i, lc);
            }
        }
    }

    public int poll(){
        if (len!=0){
            swap(0, len-1);
            len--;
            adjustFromTopToBottom();
            return nums[len];
        }
        return -1;
    }

    private void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public int top(){
        if (len!=0){
            return nums[0];
        }
        return -1;
    }

}
