package leetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Ex496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item : nums2) {
            while (!stack.isEmpty() && stack.peek() < item) {
                map.put(stack.pop(), item);
            }
            stack.push(item);
        }

        var res = new int[nums1.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }
}
