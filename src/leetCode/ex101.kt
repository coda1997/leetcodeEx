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

private fun isSameTree(root1: TreeNode?,root2: TreeNode?):Boolean{
    if (root1==null&&root2==null){
        return true
    }
    if (root1==null||root2==null){
        return false
    }
    return root1.`val`==root2.`val`&& isSameTree(root1.left,root2.left)&& isSameTree(root1.right,root2.right)
}