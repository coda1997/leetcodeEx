package review;

import leetCode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class LCA {
    private HashSet<TreeNode> set;
    private HashMap<TreeNode, TreeNode> map;

    private void dfs(TreeNode root){
        if (root == null) {
            return;
        }
        if (root.left != null) {
            map.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        set = new HashSet<>();
        map = new HashMap<>();
        dfs(root);
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        while (q != null) {
            if (set.contains(q)) {
                return q;
            }
            q = map.get(q);
        }

        return null;
    }
}
