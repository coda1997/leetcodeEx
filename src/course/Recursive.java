package course;

import java.util.ArrayList;
import java.util.List;

class Recursive {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<List<Integer>>();
        }
        if (numRows == 1) {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<Integer> t = new ArrayList<>();
            t.add(1);
            res.add(t);
            return res;
        }
        var temp = generate(numRows - 1);
        List<Integer> tt = new ArrayList<>(numRows);
        var ttt = temp.get(temp.size() - 1);
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                tt.add(1);
            } else {
                tt.add(ttt.get(i) + ttt.get(i - 1));
            }
        }
        temp.add(tt);
        return temp;
    }

    public static void main(String[] args) {
        new Recursive().generate(5);
    }
}