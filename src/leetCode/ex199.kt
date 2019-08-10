package leetCode

fun rightSideView(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    val temp = mutableListOf<TreeNode>()
    if (root != null) {
        res.add(root.`val`)
        temp.add(root.left)
        temp.add(root.right)
        while (temp.isNotEmpty()){
            res.add(temp.last().`val`)

            res.clear()

        }
    }

    return res
}

