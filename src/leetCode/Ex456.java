package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Ex456 {
    public boolean find132pattern(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        if (nums.length < 3) {
            return false;
        }
        stack.push(nums[nums.length-1]);
        int max = Integer.MIN_VALUE;
        for (int i = nums.length-2;i >=0; i--) {
            if (nums[i] < max) {
                return true;
            }
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                max = stack.pop();
            }
            if (nums[i] > max) {
                stack.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var o = new Ex456();
        System.out.println(o.find132pattern(new int[]{1,2,3,4}));
        System.out.println(o.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(o.find132pattern(new int[]{-1,3,2,0}));
    }
}
