package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Ex1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxStack = new LinkedList<>();
        Deque<Integer> minStack = new LinkedList<>();
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            while (!maxStack.isEmpty() && maxStack.peekLast() < nums[right]) {
                maxStack.pollLast();
            }
            while (!minStack.isEmpty() && minStack.peekLast() > nums[right]) {
                minStack.pollLast();
            }
            maxStack.offerLast(nums[right]);
            minStack.offerLast(nums[right]);
            while (!maxStack.isEmpty() && !minStack.isEmpty() && maxStack.peekFirst() - minStack.peekFirst() > limit) {
                if (nums[left] == maxStack.peekFirst()) {
                    maxStack.pollFirst();
                }
                if (nums[left] == minStack.peekFirst()) {
                    minStack.pollFirst();
                }
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }

        return res;
    }
}
