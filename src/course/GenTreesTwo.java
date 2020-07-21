package course;

import java.util.ArrayList;
import java.util.List;

public class GenTreesTwo {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }
        return helper(1, n+1);
    }

    private List<TreeNode> helper(int start, int end){
        if(start==end){
            var t = new ArrayList<TreeNode>();
            t.add(null);
            return t;
        }
        var res = new ArrayList<TreeNode>();
        for (int i = start; i < end; i++) {
            var lefts = helper(start, i);
            var rights = helper(i+1, end);
            
            for (TreeNode treeNode : lefts) {
                for (TreeNode treeNode2 : rights) {
                    var root = new TreeNode(i);
                    root.left = treeNode;
                    root.right = treeNode2;
                    res.add(root);
                }
            }
        }
        return res;

    }

    

}