package leetCode;

import java.util.Arrays;

public class Ex321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        var res = new int[k];
        int p = 0;
        int r1 = nums1.length;
        int r2 = nums2.length;
        int l1 = 0, l2 = 0; 
        while(p<k){
            int temp1 = -1;
            int tp1 = -1;
            int pre1 = -1;
            for (int i = l1; i < r1; i++) {
                if(r1-i+r2-l2<k-p){
                    break;
                }
                if(temp1<nums1[i]){
                    pre1 = temp1;
                    temp1 = nums1[i];
                    tp1 = i;
                }
            }
            int temp2 = -1;
            int tp2 = -1;
            int pre2 = -1;
            for (int i = l2; i < r2; i++) {
                if(r2-i+r1-l1<k-p){
                    break;
                }
                if(temp2<nums2[i]){
                    pre2 = temp2;
                    temp2 = nums2[i];
                    tp2 = i;
                }
            }
            if(temp1>temp2){
                res[p++] = temp1;
                l1 = tp1+1;
            }else if(temp1<temp2){
                res[p++] = temp2;
                l2 = tp2+1;
            }else{
                if(pre1>pre2){
                    res[p++] = temp2;
                    l2 = tp2+1;
                }else{
                    res[p++] = temp1;
                    l1 = tp1+1; 
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var o = new Ex321();
        System.out.println(Arrays.toString( o.maxNumber(new int[]{3,4,6,5}, new int[]{9,1,2,5,8,3}, 5)));
        System.out.println(Arrays.toString( o.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
        System.out.println(Arrays.toString( o.maxNumber(new int[]{3,9}, new int[]{8,9}, 3)));
        System.out.println(Arrays.toString( o.maxNumber(new int[]{8,9}, new int[]{3,9}, 3)));
    }
}
