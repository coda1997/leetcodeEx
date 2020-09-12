package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int c = 0;
        double t = 0.0;
        while (!queue.isEmpty()) {
            var item = queue.poll();
            if (item == null) {
                res.add(t / c);
                t = 0.0;
                c = 0;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else {
                t += item.val;
                ++c;
                if (item.left != null) {
                    queue.offer(item.left);
                }
                if (item.right != null) {
                    queue.offer(item.right);
                }
            }

        }
        return res;
    }

}
