package course;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import leetCode.TreeNode;

public class KthSmallestInBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while(k>0){
            var item = stack.pop();
            if(item==null){
                continue;
            }
            if(set.contains(item)){
                k--;
                if(k==0){
                    return item.val;
                }
            }else{
                set.add(item);
                stack.push(item.right);
                stack.push(item);
                stack.push(item.left);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        var o = new KthSmallestInBST();
        
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        o.kthSmallest(root, 2);
    }
}