package review;

import leetCode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left == null) {
                cur = cur.right;
            } else {
                TreeNode temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (temp.right == cur) {
                    temp.right = null;
                    addPath(res, cur.left);
                    cur = cur.right;
                }
            }
        }
        addPath(res, root);
        return res;
    }

    private void addPath(List<Integer> res, TreeNode root) {
        int c = 0;
        while (root != null) {
            res.add(root.val);
            root = root.right;
            c++;
        }
        int left = res.size() - c, right = res.size() - 1;
        while (left < right) {
            Collections.swap(res, left++, right--);
        }
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        boolean findP = false;
        while (cur != null) {
            if (cur.left == null) {
                if (findP) {
                    return cur;
                }
                if (cur == p) {
                    findP = true;
                }

                cur = cur.right;
            } else {
                var temp = cur.left;
                while (temp.right != null && temp.right != cur) {
                    temp = temp.right;
                }
                if (temp.right == null) {
                    temp.right = cur;
                    cur = cur.left;
                    continue;
                }
                if (temp.right == cur) {
                    temp.right = null;
                    if (findP) {
                        return cur;
                    }
                    if (cur == p) {
                        findP = true;
                    }
                    cur = cur.right;
                }
            }
        }
        return null;
    }
}
