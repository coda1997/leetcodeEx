package course;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetCode.TreeNode;

public class TreeBDSWithStack {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        var res = new LinkedList<List<Integer>>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        queue.add(null);
        var temp = new LinkedList<Integer>();
        while (!queue.isEmpty()) {
            var t = queue.poll();
            if (t != null) {
                temp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }else{
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
                res.add(temp);
                temp = new LinkedList<Integer>();
            }

        }
        return res;
    }

}