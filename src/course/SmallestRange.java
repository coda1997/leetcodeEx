package course;

import java.util.*;

/**
 * SmallestRange
 * 你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 *
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 */
public class SmallestRange {


    public int[] smallestRange(List<List<Integer>> nums) {
        Map<Integer, ArrayList<Integer>> qs = new HashMap<>();

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int numLen = nums.size();
        for (int i = 0; i < numLen; i++) {
            var ll = nums.get(i);
            for (Integer x : ll) {
                var list = qs.getOrDefault(x, new ArrayList<>());
                list.add(i);
                qs.put(x, list);
                max = Math.max(max, x);
                min = Math.min(min, x);
            }
        }
        int l = min - 1, r = min - 1;
        int[] cs = new int[numLen];
        int count = 0;
        int bmin = min, bmax = max;
        while (r < max) {
            r++;
            if (qs.containsKey(r)) {
                for (int x :
                        qs.get(r)) {
                    cs[x]++;
                    if (cs[x] == 1) {
                        count++;
                    }
                }
                while (count == numLen) {
                    if (bmax - bmin > r - l) {
                        bmax = r;
                        bmin = l;
                    }
                    if (qs.containsKey(l)) {
                        for (int x :
                                qs.get(l)) {
                            cs[x]--;
                            if (cs[x] == 0) {
                                count--;
                            }
                        }
                    }
                    l++;
                }

            }
        }
        return new int[]{bmin, bmax};
    }


    public static void main(String[] args) {
        var o = new SmallestRange();
        var temp = new ArrayList<List<Integer>>();
        temp.add(List.of(4, 10, 15, 24, 26));
        temp.add(List.of(0, 9, 12, 20));
        temp.add(List.of(5, 18, 22, 30));

        System.out.println(Arrays.toString(o.smallestRange(temp)));
        System.out.println(Arrays.toString(o.smallestRange(List.of(List.of(1, 3, 5, 7, 9, 10), List.of(2, 4, 6, 8, 10)))));
    }

}