package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex112 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, sum, 0);
    }

    private boolean hasPathSum(TreeNode root, int sum, int temp) {
        boolean f = false;
        if (root.left != null) {
            f = hasPathSum(root.left, sum, root.val + temp);
        }
        if (root.right != null) {
            f = f || hasPathSum(root.right, sum, root.val + temp);
        }
        if (root.left == null && root.right == null) {
            f = root.val + temp == sum;
        }
        return f;
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows==0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> e = new ArrayList<>();
        e.add(1);
        res.add(e);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            List<Integer> pre = res.get(i - 1);
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(pre.get(j - 1) + pre.get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }

    public List<Integer> getRow(int rowIndex) {

        int[] res = new int[rowIndex+1];
        res[0]=1;
        for (int i =0; i<rowIndex; i++) {
            res[i+1]=1;
            for (int j = i;j>0;j--){
                res[j] = res[j - 1] + res[j];
            }
        }
        List<Integer> rres = new ArrayList<>();
        for (int i : res) {
            rres.add(i);
        }
        return rres;
    }
}
