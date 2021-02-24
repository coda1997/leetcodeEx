package leetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Ex636 {
    public int[] exclusiveTime(int n, List<String> logs) {

        Deque<Integer> stack = new LinkedList<>();
        var res = new int[n];
        //init
        if (logs.size() < 1) {
            return res;
        }
        var items = logs.get(0).split(":");
        stack.push(Integer.valueOf(items[0]));
        var offset = Integer.valueOf(items[2]);
        for (int i = 1; i < logs.size(); i++) {
            var iits = logs.get(i).split(":");
            var id = Integer.valueOf(iits[0]);
            var time = Integer.valueOf(iits[2]);

            if (iits[1].equals("start")){
                if(!stack.isEmpty()){
                    res[stack.peek()] += time - offset;
                }
                offset = time;
                stack.push(id);
            }else{
                res[stack.peek()] += time-offset+1;
                stack.pop();
                offset= time+1;
            }
        }
        return res;
    }
}
