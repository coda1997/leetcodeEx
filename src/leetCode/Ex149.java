package leetCode;

import java.util.HashMap;

public class Ex149 {

    public int maxPoints(Point[] points) {
        if (points.length<=2){
            return points.length;
        }
        HashMap<Float, HashMap<Float,Integer>> hashMap = new HashMap<>();
        int len = points.length;
        for (int i = 0; i < len; i++) {
            Point p1 = points[i];
            for (int j = i+1; j < len; j++) {
                Point p2 = points[2];
                float k = (p2.y-p1.y)*1f/(p2.x-p1.x);
                float b = p1.y-k*p1.x;

            }
        }

        return 0;
    }
}
