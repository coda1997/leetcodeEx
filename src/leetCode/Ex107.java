package leetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ex107 {
        
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return res;
        }
        queue.offer(root);
        queue.offer(null);
        var temp = new LinkedList<Integer>();
        while(!queue.isEmpty()){
            var item = queue.poll();
            if(item==null){
                if(queue.isEmpty()){
                    res.add(0, temp);
                    break;
                }else{
                    res.add(0, temp);
                    temp = new LinkedList<Integer>();
                    queue.add(null);
                }
            }else{
                temp.add(item.val);
                if(item.left!=null){
                    queue.add(item.left);
                }
                if(item.right!=null){
                    queue.add(item.right);
                }
            }
        }
        return res;
    }
}
