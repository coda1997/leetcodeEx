package course;

import course.KthLargest.TreeNode;

public class MaxPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(helper(root.left),0);
        int right = Math.max(helper(root.right), 0);
        int tempmax = root.val+left+right;
        maxSum = Math.max(maxSum, tempmax);

        return root.val+Math.max(left, right);
    }
}