package leetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Ex387 {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            var item = s.charAt(i);
            if (map.containsKey(item)) {
                map.put(item, -1);
                while (!queue.isEmpty()&&map.get(queue.peek().item)==-1){
                    queue.poll();
                }
            } else {
                map.put(item, i);
                queue.offer(new Pair(item, i));
            }
        }
        return queue.isEmpty()?-1:queue.peek().index;

    }
    private class Pair{
        char item;
        int index;

        Pair(char item, int index) {
            this.index = index;
            this.item = item;
        }
    }
}
