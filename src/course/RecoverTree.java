package course;

import leetCode.TreeNode;

public class RecoverTree {

    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode pre = null;
        TreeNode i = null, j = null;
        TreeNode ij1 = null;
        TreeNode predecessor = null;
        int temp = 0;
        while (root != null) {
            if (root.left == null) {
                if (pre != null) {
                    if (pre.val > root.val) {
                        if (temp == 0) {
                            i = pre;
                            ij1 = root;
                            temp++;
                        } else {
                            j = root;
                        }
                    }
                }
                pre = root;
                root = root.right;
            } else {
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                } else {
                    if (pre != null) {
                        if (pre.val > root.val) {
                            if (temp == 0) {
                                i = pre;
                                ij1 = root;
                                temp++;
                            } else {
                                j = root;
                            }
                        }
                    }
                    pre = root;
                    predecessor.right = null;
                    root = root.right;
                }
            }

        }
        if (j == null) {
            j = ij1;
        }
        var tt = i.val;
        i.val = j.val;
        j.val = tt;
    }

}