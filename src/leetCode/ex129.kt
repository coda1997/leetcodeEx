package leetCode

import java.util.*
import kotlin.collections.HashSet
import kotlin.test.assertEquals

fun sumNumbers(root: TreeNode?): Int {
    var t = 0
    var tt = 0
    if (root == null) {
        return t
    }
    val stack = Stack<TreeNode>()
    val set = HashSet<TreeNode>()
    stack.add(root)
    while (stack.isNotEmpty()) {
        val p = stack.peek()
        if (set.contains(p)) {
            t /= 10
            stack.pop()
        } else {
            if (p.left == null && p.right == null) {
                tt+=t*10+p.`val`
                stack.pop()
            }else{
                t=t*10+p.`val`
                set.add(p)
            }
            if (p.right != null) {
                stack.push(p.right)
            }
            if (p.left != null) {
                stack.push(p.left)
            }
        }
    }
    return tt
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    assertEquals(25, sumNumbers(root))
}

