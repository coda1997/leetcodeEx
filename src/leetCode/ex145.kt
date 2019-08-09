package leetCode

import java.util.*

fun postorderTraversal(root: TreeNode?): List<Int> {
    val stack = Stack<TreeNode>()
    val res = mutableListOf<Int>()
    if (root == null) {
        return res
    }
    stack.push(root)
    while (stack.isNotEmpty()){
        val t = stack.pop()
        res.add(0,t.`val`)
        if (t.left != null) {
            stack.push(t.left)
        }
        if (t.right != null) {
            stack.push(t.right)
        }
    }
    return res
}

fun main() {
    val t = TreeNode(1)
    t.left = TreeNode(2)
    t.right= TreeNode(3)
    t.left.left = TreeNode(4)
    t.right.left = TreeNode(5)
    postorderTraversal(t).forEach(::println)
}