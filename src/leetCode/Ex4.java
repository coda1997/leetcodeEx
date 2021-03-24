package leetCode;

public class Ex4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        if (len % 2 == 1) {
            return helper(nums1, nums2, len / 2 + 1);
        }else{
            return (helper(nums1, nums2, len/2)+helper(nums1, nums2, len/2+1))/2.0;
        }
    }

    private double helper(int[] nums1, int[] nums2, int k){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1==len1){
                return nums2[index2+k-1];
            }
            if (index2==len2){
                return nums1[index1+k-1];
            }
            if (k==1){
                return Math.min(nums1[index1], nums2[index2]);
            }else{
                int newIndex1 = Math.min(len1, index1+k/2)-1;
                int newIndex2 = Math.min(len2, index2+k/2)-1;
                if (nums1[newIndex1]<=nums2[newIndex2]){
                    k-= newIndex1-index1+1;
                    index1 = newIndex1+1;
                }else{
                    k-= newIndex2-index2+1;
                    index2 = newIndex2+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        var o = new Ex4();
        System.out.println(o.findMedianSortedArrays(new int[]{1, 3,4}, new int[]{2}));
    }
}
