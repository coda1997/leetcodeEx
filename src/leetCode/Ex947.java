package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ex947 {
    public int removeStones(int[][] stones) {
        UnionFind unionFind = new UnionFind();
        for (var stone :
                stones) {
            unionFind.union(stone[0] + 1001, stone[1]);
        }
        return stones.length - unionFind.getCount();
    }


    public static void main(String[] args) {
        var o = new Ex947();
        System.out.println(o.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2}}));
    }


    class UnionFind {
        private Map<Integer, Integer> parent;
        private int count;

        public UnionFind() {
            count = 0;
            parent = new HashMap<>();
        }

        public int find(int i) {
            if (!parent.containsKey(i)) {
                parent.put(i, i);
                count++;
            }

            if (parent.get(i) != i) {
                parent.put(i, find(parent.get(i)));
            }
            return parent.get(i);
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return;
            }
            parent.put(rootI, rootJ);
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
