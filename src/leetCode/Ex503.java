package leetCode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Ex503 {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0;i< nums.length;i++) {
            var num = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                map.put(stack.pop(), i);
            }
            stack.push(i);
        }
        for (int i = 0;i< nums.length;i++) {
            var num = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                map.put(stack.pop(), i);
            }
        }
        var res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(i)) {
                res[i] = nums[map.get(i)];
            }else{
                res[i] = -1;
            }
        }

        return res;
    }
}
