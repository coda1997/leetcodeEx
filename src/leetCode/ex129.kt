package leetCode

fun sumNumbers(root: TreeNode?): Int {
    var sum = 0
    var temp = 0
    if (root == null) {
        return sum
    }
    var parents = mutableListOf<TreeNode>()

    parents.add(root)
    var children = mutableListOf<TreeNode>()
    while (parents.isNotEmpty()) {
        for (p in parents) {
            p.left?.apply {
                temp += p.`val`
                children.add(this)
            }
            p.right?.apply {
                children.add(this)
                temp += p.`val`
            }
        }
        sum = sum * 10 + temp
        val tt = parents
        parents = children
        children = tt
        children.clear()
    }
    return sum
}