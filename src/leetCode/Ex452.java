package leetCode;

import java.util.Arrays;

public class Ex452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length < 2) {
            return points.length;
        }
        Arrays.sort(points, ((o1, o2) -> {
            if (o1[1] > o2[1]) {
                return 1;
            } else if (o1[1] < o2[1]) {
                return -1;
            } else {
                return 0;
            }
        }));
        int r = points[0][1];
        int res = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > r) {
                res++;
                r = points[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        var o = new Ex452();
        System.out.println(o.findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}));
    }
}
