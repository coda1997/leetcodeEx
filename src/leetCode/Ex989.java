package leetCode;

import java.util.LinkedList;
import java.util.List;

public class Ex989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        int up = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            int t = K % 10;
            K /= 10;
            res.add(0, (t + A[i] + up) % 10);
            up = (t + A[i] + up) / 10;
        }
        while (up != 0 || K > 0) {
            int t = K % 10;
            K /= 10;
            res.add(0, (up + t) % 10);
            up = (up + t) / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Ex989();
        System.out.println(o.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(o.addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(o.addToArrayForm(new int[]{9, 9, 9}, 11));
        System.out.println(o.addToArrayForm(new int[]{0}, 1000));
    }
}
