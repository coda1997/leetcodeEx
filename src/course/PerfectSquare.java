package course;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class PerfectSquare {
    public int numSquares(int n) {
        var squares = new ArrayList<Integer>();
        for (int i = 0; i*i <= n; i++) {
            squares.add(i*i);
        }
        HashSet<Integer> queue = new HashSet<>();
        queue.add(n);
        int depth=0;
        while(queue.size()>0){
            depth++;
            var nextqueue = new HashSet<Integer>();
            for(var i:queue){
                for(var j:squares){
                    if(i.equals(j)){
                        return depth;
                    }else if(i<j){
                        break;
                    }else{
                        nextqueue.add(i-j);
                    }
                }
            }
            queue = nextqueue;
        }
        return -1;

    }
}