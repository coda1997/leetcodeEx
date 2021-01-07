package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Ex1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(stones).forEach(queue::offer);
        while (queue.size() > 1) {
            var item = queue.poll();
            var item2 = queue.poll();
            if (!item.equals(item2)) {
                queue.offer(Math.abs(item - item2));
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}
