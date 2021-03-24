package review;

import leetCode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class BuildTree {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Deque<TreeNode> stack = new LinkedList<>();
        if (inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        stack.push(root);
        int inorderIndex = inorder.length-1;
        for (int i = postorder.length-2; i >=0 ; i--) {
            int inorderVal = inorder[inorderIndex];
            var item = stack.peek();
            if (item.val!=inorderVal){
                item.right =  new TreeNode(postorder[i]);
                stack.push(item.right);
            }else{
                while (!stack.isEmpty()&&stack.peek().val==inorderVal){
                    inorderIndex--;
                    inorderVal = inorder[inorderIndex];
                    item = stack.pop();
                }
                item.left = new TreeNode(postorder[i]);
                stack.push(item.left);
            }
        }
        return root;
    }
}
