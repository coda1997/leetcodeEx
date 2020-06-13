package course;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.List;
import course.KthLargest.TreeNode;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        var res = new LinkedList<Integer>();
        if(root==null){
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            var temp = stack.pop();
            if(visited.contains(temp)){
                res.add(temp.val);
            }else{
                visited.add(temp);
                if(temp.right!=null){
                    stack.push(temp.right);
                }
                stack.push(temp);
                if(temp.left!=null){
                    stack.push(temp.left);
                }
            }
        }
        return res;
    }
}