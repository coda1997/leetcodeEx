package course;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import leetCode.TreeNode;

public class RecoverTree {

    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        if(root==null){
            return;
        }
        stack.push(root);
        TreeNode pre = null;
        TreeNode i = null,j=null;
        TreeNode ij1 = null;
        int temp = 0;
        while(!stack.isEmpty()){
            var item = stack.pop();
            if(set.contains(item)){
                if(pre != null){
                    if(pre.val>item.val){
                        if(temp==0){
                            i = pre;
                            ij1 = item;
                            temp++;
                        }else{
                            j = item;
                            break;
                        }
                    }
                }
                pre = item;
            }else{
                set.add(item);
                if(item.right!=null){
                    stack.push(item.right);
                }
                stack.push(item);
                if(item.left!=null){
                    stack.push(item.left);
                }
            }
        }
        if(j==null){
            j = ij1;
        }
        var tt = i.val;
        i.val = j.val;
        j.val = tt;
    }
    
}