package leetCode


//fun minDepth(root: TreeNode?): Int {
//    if (root==null) return 0
//    if (root.left==null&&root.right!=null){ return 2}
//    if (root.left!=null&&root.right==null){return 2}
//    return minDepthh(root)
//}

fun minDepthh(root: TreeNode?):Int{
    if (root==null) return 0
    return Math.min(minDepthh(root.left), minDepthh(root.right))+1
}
fun minDepth(root: TreeNode?):Int{
    if (root==null) return 0
    if (root.left==null&&root.right!=null) return minDepth(root.right)+1
    if (root.right==null&&root.left!=null) return minDepth(root.left)+1
    return Math.min(minDepth(root.left), minDepth(root.right))+1
}