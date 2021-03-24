package leetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Ex84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int[] lmin = new int[heights.length];
        Arrays.fill(lmin, -1);
        int[] rmin = new int[heights.length];
        Arrays.fill(rmin, heights.length);
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                rmin[stack.pop()] = i;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                lmin[stack.pop()] = i;
            }
            stack.push(i);
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int t = heights[i] * (rmin[i] - lmin[i] - 1);
            res = Math.max(res, t);
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Ex84();
        System.out.println(o.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
