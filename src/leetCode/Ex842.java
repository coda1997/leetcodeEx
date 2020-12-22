package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex842 {
    private int[] pres;

    public List<Integer> splitIntoFibonacci(String S) {
        var res = new ArrayList<Integer>();
        var cc = S.toCharArray();
        if (cc.length < 3) {
            return res;
        }
        pres = new int[cc.length];
        Arrays.fill(pres, -2);
        for (int i = 2; i < cc.length; i++) {
            for (int j = 1; j < i; j++) {
                int ll = pres[j];
                if (ll == -2) {
                    ll = getInt(cc, 0, j);
                    pres[j] = ll;
                }
                int rr = getInt(cc, j, i);
                if (ll == -1 || rr == -1) {
                    continue;
                }
                res.add(ll);
                res.add(rr);
                int p = i;
                int temp = ll + rr;
                while (p < cc.length) {
                    int tlen = getDidit(temp);
                    if (p + tlen > cc.length || !matchInt(temp, cc, p, p + tlen)) {
                        break;
                    }
                    res.add(temp);
                    ll = rr;
                    rr = temp;
                    temp = ll + rr;
                    p = p + tlen;

                }
                if (p == cc.length) {
                    return res;
                } else {
                    res.clear();
                }
            }
        }
        return res;
    }

    private int getDidit(int item) {
        if (item == 0) {
            return 1;
        }
        int i = 0;
        while (item > 0) {
            item /= 10;
            i++;
        }
        return i;
    }


    private int getInt(char[] cc, int l, int r) {

        if (cc[l] == '0' && r - l > 1) {
            return -1;
        }
        int res = 0;
        while (l < r) {
            res = res * 10 + (cc[l] - '0');
            l++;
        }
        return res;
    }

    private boolean matchInt(int item, char[] cc, int l, int r) {
        while (l < r) {
            if (cc[r - 1] - '0' != item % 10) {
                return false;
            }
            r--;
            item /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        var o = new Ex842();
        for (var item : o.splitIntoFibonacci("11235813")) {
            System.out.println(item);
        }
    }
}
