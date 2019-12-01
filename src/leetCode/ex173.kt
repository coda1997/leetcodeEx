package leetCode

import java.util.*
import kotlin.collections.HashSet

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class BSTIterator(root: TreeNode?) {
    val set = HashSet<TreeNode>()
    val stack = Stack<TreeNode>()
    init {
        if (root!=null){
            stack.push(root)
        }
    }
    /** @return the next smallest number */
    fun next(): Int {
        while (stack.isNotEmpty()){
            val p = stack.pop()
            if (set.contains(p)){
                return p.`val`
            }else{
                set.add(p)
                if (p.right!=null){
                    stack.push(p.right)
                }
                stack.push(p)
                if (p.left!=null){
                    stack.push(p.left)
                }
            }
        }
        return 0
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return stack.isNotEmpty()
    }

}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * var obj = BSTIterator(root)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */