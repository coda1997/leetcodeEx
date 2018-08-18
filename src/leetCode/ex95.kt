package leetCode

fun generateTrees(n: Int): List<TreeNode?> {
    return dfsTree(1, n)
}

private fun dfsTree(begin: Int, end: Int): MutableList<TreeNode> {
    val res = mutableListOf<TreeNode>()
    if (begin > end) {
        return res
    } else if (begin == end) {
        res.add(TreeNode(begin))
        return res
    }
    (begin..end).forEach {
        val left = dfsTree(begin, it - 1)
        val right = dfsTree(it + 1, end)
        left.forEach { litem ->
            right.forEach { ritem ->
                res.add(TreeNode(it).apply {
                    this.left = litem
                    this.right = ritem
                })
            }
        }
        if (left.isEmpty() && right.isNotEmpty()) {
            right.forEach { ritem ->
                res.add(TreeNode(it).apply { this.right = ritem })
            }
        }
        if (left.isNotEmpty() && right.isEmpty()) {
            left.forEach { litem ->
                res.add(TreeNode(it).apply { this.left = litem })
            }
        }
    }
    return res

}