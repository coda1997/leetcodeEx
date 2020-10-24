package leetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Ex321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        var res = new int[k];
        for (int i = 0; i <= k; i++) {
            if(i>len1||k-i>len2){
                continue;
            }
            var res1 = helper(nums1, i);
            var res2 = helper(nums2, k-i);
            var ress = findMax(res1, res2, k);
            if(bg(ress, res)){
                res = ress;
            }
        }
        return res;
    }
    private boolean bg(int[] n1, int[] n2){
        //the length of n1 and n2 are both k
        for (int i = 0; i < n1.length; i++) {
            if(n1[i]<n2[i]){
                return false;
            }else if(n1[i]>n2[i]){
                return true;
            }
        }
        return true;
    }
    private boolean arraysBg(int[] n1, int[] n2, int i, int j){
        int len1 = n1.length;
        int len2 = n2.length;
        while(i<len1&&j<len2){
            if(n1[i]>n2[j]){
                return true;
            }else if(n1[i]<n2[j]){
                return false;
            }else{
                i++;
                j++;
            }
        }
        if(i==len1){
            return false;
                
        }
        if(j==len2){
            return true;
        }
        return false;
    }
    private int[] findMax(int[] nums1, int[] nums2, int k){
        if(nums1==null){
            return nums2;
        }
        if(nums2==null){
            return nums1;
        }
        int i = 0;
        int j = 0;
        var res = new int[k];
        int p = 0;
        while(i<nums1.length&&j<nums2.length){
            if(arraysBg(nums1, nums2, i, j)){
                res[p++] = nums1[i++];
            }else{
                res[p++] = nums2[j++];
            }
        }
        while(i<nums1.length){
            res[p++] = nums1[i++];
        }
        while(j<nums2.length){
            res[p++] = nums2[j++];
        }
        return res;
    }

    private int[] helper(int[] nums, int k){
        if(k==0){
            return null;
        }
        int drop = nums.length-k;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0;i<nums.length;i++){
            var item = nums[i];
            while(drop>0&&!stack.isEmpty()&&stack.peek()<item){
                stack.pop();
                drop--;
            }
            stack.push(item);
        }
        var res = new int[k];
        int len= stack.size();
        while(len>k){
            stack.pop();
            len--;
        }
        while(k>0){
            res[--k] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Ex321();
        System.out.println(Arrays.toString( o.maxNumber(new int[]{3,4,6,5}, new int[]{9,1,2,5,8,3}, 5)));
        System.out.println(Arrays.toString( o.maxNumber(new int[]{6, 7}, new int[]{6, 0, 4}, 5)));
        System.out.println(Arrays.toString( o.maxNumber(new int[]{3,9}, new int[]{8,9}, 3)));
        System.out.println(Arrays.toString( o.maxNumber(new int[]{8,9}, new int[]{3,9}, 3)));
        System.out.println(Arrays.toString( o.maxNumber(new int[]{6,3,9,0,5,6}, new int[]{2,2,5,2,1,4,4,5,7,8,9,3,1,6,9,7,0}, 23)));
    }
}
