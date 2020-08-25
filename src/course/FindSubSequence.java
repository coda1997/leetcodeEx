package course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSubSequence {


    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        //用个尾递归
        helper(nums, 0, Integer.MIN_VALUE);
        return res;
    }



    private void helper(int[] nums, int end, int last){
        if(end==nums.length){
            if(temp.size()>=2){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if(nums[end]>=last){
            temp.add(nums[end]);
            helper(nums, end+1, nums[end]);
            temp.remove(temp.size()-1);
        }

        if(nums[end]!=last){
            helper(nums, end+1, last);
        }
    }

    public static void main(String[] args) {
        var o = new FindSubSequence();
        var res = o.findSubsequences(new int[]{4,6,7,7});
        for (var list : res) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}