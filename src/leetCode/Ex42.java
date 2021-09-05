package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class Ex42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int width = i-left-1;
                res += width*(Math.min(height[left],height[i])-height[top]);

            }
            stack.push(i);
        }
        return res;
    }
}
