package review;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Morris {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null){
            if (cur.left==null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                //note: the right pointer points to cur.left;
                //then find the most right leaf and change its right pointer.
                TreeNode right = cur.left;
                while (right.right!=null&&right.right!=cur){
                    right=right.right;
                }
                if (right.right==null){
                    right.right = cur;
                    cur = cur.left;
                }
                if (right.right==cur){
                    res.add(cur.val);
                    cur = cur.right;
                    right.right = null;
                }
            }
        }
        return res;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while(cur!=null){
            if (cur.left==null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode succ = cur.left;
                while(succ.right!=null&&succ.right!=cur){
                    succ = succ.right;
                }
                if (succ.right==null){
                    succ.right = cur;
                    res.add(cur.val);
                    cur = cur.left;//note its important
                }
                if (succ.right==cur){
                    succ.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
