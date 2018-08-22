package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex102 {


    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        ArrayList<TreeNode> tt = new ArrayList<>();
        if (root == null) {
            return res;
        }
        tt.add(root);
        while (!tt.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            ArrayList<TreeNode> ttt = new ArrayList<>();

            genListInSingleLevel(tt, temp, ttt);
            res.add(temp);
            tt = ttt;
        }
        return res;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<TreeNode> tt = new ArrayList<>();
        if (root == null) {
            return res;
        }
        tt.add(root);
        while (!tt.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            ArrayList<TreeNode> ttt = new ArrayList<>();

            genListInSingleLevel(tt, temp, ttt);
            res.add(0, temp);
            tt = ttt;
        }
        return res;
    }

    private void genListInSingleLevel(ArrayList<TreeNode> tt, List<Integer> temp, ArrayList<TreeNode> ttt) {
        for (TreeNode node : tt) {
            temp.add(node.val);
            if (node.left != null) {
                ttt.add(0,node.left);
            }
            if (node.right != null) {
                ttt.add(0,node.right);
            }
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<TreeNode> tt = new ArrayList<>();
        if (root == null) {
            return res;
        }
        tt.add(root);
        boolean flag = true;
        while (!tt.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            ArrayList<TreeNode> ttt = new ArrayList<>();

            if (flag) {
                for (TreeNode node : tt) {
                    temp.add(node.val);
                    if (node.left != null) {
                        ttt.add( node.left);
                    }
                    if (node.right != null) {
                        ttt.add(node.right);
                    }
                }
                flag = false;
            } else {
                flag=true;
                for (int i = tt.size() - 1; i >= 0; i--) {
                    TreeNode node = tt.get(i);
                    temp.add(node.val);
                    if (node.right != null) {
                        ttt.add(0,node.right);
                    }
                    if (node.left != null) {
                        ttt.add( 0,node.left);
                    }
                }
            }
            res.add(temp);
            tt = ttt;
        }
        return res;
    }
}
