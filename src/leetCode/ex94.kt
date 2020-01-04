package leetCode

import java.util.*
import kotlin.collections.HashSet

fun inorderTraversal(root: TreeNode?): List<Int> {
    val stack = Stack<TreeNode>()
    val set = HashSet<TreeNode>()
    val res = mutableListOf<Int>()
    if (root == null) {
        return emptyList()
    }
    stack.push(root)
    while (stack.isNotEmpty()) {
        val t = stack.pop()
        if (set.contains(t)) {
            res.add(t.`val`)
        } else {
            if (t.right != null) {
                stack.push(t.right)
            }
            stack.push(t)
            set.add(t)
            if (t.left != null) {
                stack.push(t.left)
            }
        }
    }
    return res
}