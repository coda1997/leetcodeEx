package course;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTem {
    public int[] dailyTemperatures(int[] T) {
        Deque<Integer> stack = new LinkedList<>();
        var res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            var item = T[i];
            while(!stack.isEmpty()&&item>T[stack.peek()]){
                var index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println( new DailyTem().dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 }));
    }
}