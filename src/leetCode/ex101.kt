package leetCode

fun isSymmetric(root: TreeNode?): Boolean {
    if (root==null) return true
    return isSameTree(invertTree(root.left),root.right)
}

private fun invertTree(root: TreeNode?): TreeNode? {
    if (root != null){
        val temp = invertTree(root.left)
        root.left= invertTree(root.right)
        root.right=temp
    }
    return root
}

