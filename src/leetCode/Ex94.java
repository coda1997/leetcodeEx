package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Ex94 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode temp = stack.pop();
            while (temp.left != null) {
                stack.push(temp);
                temp = temp.left;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Ex94 ex94 = new Ex94();
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode.right = treeNode2;
        treeNode2.left = treeNode3;
        List<Integer> res = ex94.inorderTraversal(treeNode);
        res.forEach(System.out::println);
    }
}
