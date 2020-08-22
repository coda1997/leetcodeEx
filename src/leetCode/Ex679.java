package leetCode;

import java.util.ArrayList;

public class Ex679 {
    private static final int ADD = 0, MUL = 1, DIV = 3, SUB = 2;
    private final double EP = 6e-6;

    public boolean judgePoint24(int[] nums) {
        var list = new ArrayList<Double>();
        for (int i :
                nums) {
            list.add(i + 0.0);
        }
        return helper(list);
    }

    private boolean helper(ArrayList<Double> list) {


        int size = list.size();
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            return (24 - EP < list.get(0)) && (list.get(0) < 24 + EP);
        }
        for (int i = 0; i < size; i++) {
            var t1 = list.get(i);
            for (int j = 0; j < size; j++) {
                if (i == j) {
                    continue;
                }
                var t2 = list.get(j);
                var list2 = new ArrayList<Double>();
                for (int k = 0; k < size; k++) {
                    if (k != i && k != j) {
                        list2.add(list.get(k));
                    }
                }
                for (int k = 0; k < 4; k++) {
                    if (k < 2 && i > j) {
                        continue;
                    }
                    if (k == ADD) {
                        list2.add(t1 + t2);
                    } else if (k == SUB) {
                        list2.add(t1 - t2);
                    } else if (k == MUL) {
                        list2.add(t1 * t2);
                    } else {
                        if (t2 == 0.0) {
                            continue;
                        } else {
                            list2.add(t1 / t2);
                        }
                    }
                    if (helper(list2)) {
                        return true;
                    }
                    list2.remove(list2.size() - 1);
                }
            }
        }
        return false;
    }

}