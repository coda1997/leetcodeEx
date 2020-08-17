package course;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetCode.TreeNode;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        queue.offer(root);
        queue.offer(null);
        while(!queue.isEmpty()){
            var item = queue.poll();
            if(item==null){
                if(!queue.isEmpty()){
                    queue.offer(null);
                }
            }else{
                if(queue.peek()==null){
                    res.add(item.val);
                }
                if(item.left!=null){
                    queue.offer(item.left);
                }
                if(item.right!=null){
                    queue.offer(item.right);
                }
            }
        }
        return res;
    }
}