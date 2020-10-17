package leetCode;

public class Ex52 {
    int res = 0;
    int n;
    int a = 0, b = 0, c = 0, d = 0;

    public int totalNQueens(int n) {
        this.n = n;
        helper(n, 0, 0);
        return res;
    }

    private void helper(int k, int i, int j) {
        if (check(i, j)) {
            flip(i, j);
            if (j < n - 1) {
                helper(k-1, i, j + 1);
            } else if (i < n - 1) {
                helper(k-1, i + 1, 0);
            } else {
                if (k == 1) {
                    res++;
                }
            }
            flip(i, j);
        }
        if (j < n - 1) {
            helper(k, i, j + 1);
        } else if (i < n - 1) {
            helper(k, i + 1, 0);
        } else {
            if (k == 0) {
                res++;
            }
        }
    }

    private void flip(int i, int j) {
        a ^= 1 << i;
        b ^= 1 << j;
        c ^= 1 << (i + j);
        d ^= 1 << (i - j + n);
    }

    private boolean check(int i, int j) {
        return ((a &1 << i) == 0) && ((b & 1<< j) == 0) && ((c & 1<< (i + j)) == 0) && ((d & 1<< (i - j + n)) == 0);
    }
}
