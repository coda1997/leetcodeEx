package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Ex257 {
    private List<String> res;
    private StringBuilder stringBuilder;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        stringBuilder = new StringBuilder();
        
        helper(root);
        return res;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(stringBuilder.toString() + root.val);
        }
        var len = stringBuilder.length();
        stringBuilder.append(root.val).append("->");
        helper(root.left);
        helper(root.right);
        stringBuilder.delete(len, stringBuilder.length());
    }
}
