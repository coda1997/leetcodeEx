package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Ex959 {
    public int regionsBySlashes(String[] grid) {
        int n = grid[0].length();
        int[] f = new int[n * n * 4];
        for (int i = 0; i < f.length; i++) {
            f[i] = i;
        }
        for (int row = 0; row < n; row++) {
            var item = grid[row].toCharArray();
            for (int col = 0; col < n; col++) {
                int offset = (row * n + col) * 4;
                if (item[col] == ' ') {
                    union(f, offset, offset + 1);
                    union(f, offset, offset + 2);
                    union(f, offset, offset + 3);
                } else if (item[col] == '\\') {
                    union(f, offset, offset + 1);
                    union(f, offset + 2, offset + 3);
                } else {
                    union(f, offset, offset + 3);
                    union(f, offset + 1, offset + 2);
                }
                if (row < n - 1) {
                    union(f, offset + 2, ((row + 1) * n + col) * 4);
                }
                if (col < n - 1) {
                    union(f, offset + 1, (row * n + col + 1) * 4 + 3);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < f.length; i++) {
            set.add(find(f, i));
        }
        return set.size();
    }


    private int find(int[] f, int i) {
        if (f[i] != i) {
            f[i] = find(f, f[i]);
        }
        return f[i];
    }

    private void union(int[] f, int i, int j) {
        int fI = find(f, i);
        int fJ = find(f, j);
        f[fI] = fJ;
    }

    public static void main(String[] args) {
        var o = new Ex959();
        System.out.println(o.regionsBySlashes(new String[]{" /", "  "}));
    }
}
