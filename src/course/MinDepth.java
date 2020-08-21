package course;

import java.util.Queue;
import leetCode.TreeNode;
/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明: 叶子节点是指没有子节点的节点。
 */
public class MinDepth {

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int d = 1;

        while(!queue.isEmpty()){
            var item = queue.poll();
            if(item==null){
                if(!queue.isEmpty()){
                    queue.offer(null);
                    d++;
                }
            }else{
                if(item.left==null&&item.right==null){
                    break;
                }
                if(item.left!=null){
                    queue.offer(item.left);
                }
                if(item.right!=null){
                    queue.offer(item.right);
                }
            }
        }
        return d;

    }

    /**
     * 递归比循环快这是我没想到的
     */
    public int minDepth2(TreeNode root){
        if(root==null){
            return 0;
        }
        var l = minDepth2(root.left);
        var r = minDepth2(root.right);
        if(l==0&&r==0){
            return 1;
        }
        if(l==0){
            return r+1;
        }
        if(r==0){
            return l+1;
        }
        return Math.min(l, r)+1;
    }
}