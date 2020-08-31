package leetCode;

import java.util.PriorityQueue;
/**
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 */
public class Ex451 {
    public String frequencySort(String s) {
        int[] set = new int[128];
        for (char i : s.toCharArray()) {
            set[i]++;
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(128, (a,b)->Integer.compare(set[a], set[b]));
        for (int i = 0; i < set.length; i++) {
            if(set[i]>0){
                queue.offer((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            var item = queue.poll();
            while(set[item]-->0){
                sb.append(item);
            }
        }
        return sb.toString();
    }
}