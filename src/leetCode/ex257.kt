package leetCode

fun binaryTreePaths(root: TreeNode?): List<String> {
    val res = mutableListOf<String>()
    if (root != null) {
        val path = "${root.`val`}"
        dfsTreePath(root.left, path, res)
        dfsTreePath(root.right, path, res)
        if (root.left == null && root.right == null) {
            res.add(path)
        }
    }
    return res
}

private fun dfsTreePath(root: TreeNode?, path: String, res: MutableList<String>) {
    if (root == null) {
        return
    }
    val t = "$path->${root.`val`}"
    dfsTreePath(root.left, t, res)
    dfsTreePath(root.right, t, res)
    if (root.left == null && root.right == null) {
        res.add(t)
    }
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.left.right = TreeNode(5)
    root.right = TreeNode(3)
    binaryTreePaths(root).forEach { println(it) }
}