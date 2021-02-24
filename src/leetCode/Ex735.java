package leetCode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Ex735 {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        int i = 0;
        while (i < asteroids.length) {
            if (stack.isEmpty() || stack.peek() * asteroids[i] > 0) {
                stack.push(asteroids[i++]);
            } else {
                var item = stack.pop();
                var absItem = Math.abs(item);
                var abs = Math.abs(asteroids[i]);
                if (absItem > abs) {
                    stack.push(item);
                    i++;
                } else if (absItem == abs) {
                    i++;
                }
            }
        }
        var res = new int[stack.size()];
        for (int j = res.length - 1; j >= 0; j--) {
            res[j] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Ex735();
        System.out.println(Arrays.toString(o.asteroidCollision(new int[]{5, 10, -5})));
    }
}
