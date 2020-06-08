package course;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Openlock {

    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        HashSet<String> isUsed = new HashSet<>();
        HashSet<String> dead = new HashSet<>();
        for (var i : deadends) {
            dead.add(i);
        }
        queue.offer("0000");
        queue.offer(null);
        isUsed.add("0000");
        int depth = 0;
        while (!queue.isEmpty()) {
            var temp = queue.poll();
            if (temp == null) {
                depth++;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else if (temp.equals(target)) {
                return depth;
            } else if (!dead.contains(temp)) {
                for (int i = 0; i < 4; i++) {
                    for (int j = -1; j <= 1; j += 2) {
                        int modified = ((temp.charAt(i) - '0') + j + 10) % 10;
                        String s = temp.substring(0, i) + "" + modified + temp.substring(i + 1);
                        if (!(isUsed.contains(s))) {
                            queue.offer(s);
                            isUsed.add(s);
                        }
                    }
                }
            }
        }
        return -1;
    }
}