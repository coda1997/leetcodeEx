package course;

import java.util.LinkedList;

public class BeautfulArray {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        var s = new LinkedList<Integer>();
        s.add(1);
        for (int i = 1; i < n; i++) {
            var iterator = s.iterator();
            var temp = new LinkedList<Integer>();
            var pre = iterator.next();
            int count = 1;
            while (iterator.hasNext()) {
                var t = iterator.next();
                if (t == pre) {
                    count++;
                } else {
                    temp.add(count);
                    temp.add(pre);
                    count = 1;
                    pre = t;
                }
            }
            temp.add(count);temp.add(pre);
            s = temp;
        }
        var builder = new StringBuilder();
        var i = s.iterator();
        while(i.hasNext()){
            builder.append(i.next());
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        System.out.println( new BeautfulArray().countAndSay(4));
    }
}