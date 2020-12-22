package leetCode;

import java.util.*;

public class Ex103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        var res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        queue.offer(null);
        boolean ltr = true;
        var currentLayer = new LinkedList<Integer>();
        while (!queue.isEmpty()) {
            var item = queue.poll();
            if (item == null) {
                ltr = !ltr;
                res.add(currentLayer);
                if (queue.isEmpty()) {
                    break;
                } else {
                    currentLayer = new LinkedList<>();
                    queue.offer(null);
                }
            } else {
                if(ltr){
                    currentLayer.offerLast(item.val);
                }else {
                    currentLayer.offerFirst(item.val);
                }
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

    public static void main(String[] args) {
        var o = new Ex103();
        var root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        var res = o.zigzagLevelOrder(root);
        for (var item :
                res) {
            item.forEach(System.out::print);
            System.out.println();
        }
    }
}
