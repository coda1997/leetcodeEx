package leetCode

fun isBalanced(root: TreeNode?): Boolean {
    if (root==null) return true
    return Math.abs(maxDepth(root.left)- maxDepth(root.right))<=1&& isBalanced(root.left)&& isBalanced(root.right)
}